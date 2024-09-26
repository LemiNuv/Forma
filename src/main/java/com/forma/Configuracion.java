package com.forma;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Configuracion {
    private Plano plano;
    Efecto efecto = new Efecto();
    private LeerFichero leerFichero;
    private boolean estadisticasActivas = false;

    public Configuracion(Plano plano, LeerFichero leerFichero) {
        this.plano = plano;
        this.leerFichero = leerFichero;
    }

    public void mostrarConfiguracion() {
        efecto.limpiarPantalla();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println(efecto.negrita("Configuración:"));
            System.out.println("1. Mostrar estadísticas e información extra: " + (plano.isEstadisticas() ? efecto.verde("Activado"):"Desactivado"));
            System.out.println("2. Configurar caracteres del plano");
            System.out.println("3. Configurar carácter de llenado por defecto: [" + efecto.verde(leerFichero.getCaracterDeLlenado()) +"]");
            System.out.println("4. Restablecer a caracteres predeterminados");
            System.out.println("5. Volver al menú principal");
            int configOpcion = -1;
            try {
                configOpcion = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(efecto.rojo("Opción no válida."));
                in.next();
                continue;
            }
            switch (configOpcion) {
                case 1:
                    activarEstadisticas();
                    break;
                case 2:
                    configurarCaracteres();
                    break;
                case 3:
                    configurarCaracterDeLlenado();
                    break;
                case 4:
                    restablecerCaracteres();
                    break;
                case 5:
                    efecto.limpiarPantalla();
                    return;
                default:
                    System.out.println(efecto.rojo("Opción no válida."));
                    break;
            }
        }
    }

    public void activarEstadisticas() {
        estadisticasActivas = !estadisticasActivas;
        plano.setEstadisticas(estadisticasActivas);
        if (estadisticasActivas) {
            System.out.println(efecto.verde("Se mostrarán las estadísticas del patrón"));
        } else {
            System.out.println(efecto.verde("Estadísticas ocultas."));
        }
        System.out.println();
    }

    public void restablecerCaracteres() {
        String caracterVacio = "░░";
        String caracterLleno = "██";
        plano.setCaracterVacio(caracterVacio);
        plano.setCaracterLleno(caracterLleno);
        System.out.println(efecto.verde("Se han restablecido los caracteres."));
    }

    public void configurarCaracteres() {
        Scanner in = new Scanner(System.in);
        System.out.println(efecto.negrita("Configura tus caracteres para el plano:"));
        while (true) {
            System.out.println("Introduce el carácter para 'true': ");
            String input = in.next();
            plano.setCaracterVacio(input);
            System.out.println(efecto.verde("Carácter guardado."));
            break;
        }
        while (true) {
            System.out.println("Introduce el carácter para 'false':");
            String input = in.next();
            plano.setCaracterLleno(input);
            System.out.println(efecto.verde("Carácter guardado."));
            break;
        }
    }

    public void configurarCaracterDeLlenado() {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce el nuevo carácter de llenado:");
        String nuevoCaracter = in.next();
        leerFichero.configurarCaracterDeLlenado(nuevoCaracter);
        System.out.println("Carácter de llenado actualizado a: " + nuevoCaracter);
    }
}