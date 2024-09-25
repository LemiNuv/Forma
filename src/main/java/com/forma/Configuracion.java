package com.forma;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Configuracion {
    Scanner in = new Scanner(System.in);
    Efecto efecto = new Efecto();
    private Plano plano;
    private boolean estadisticasActivas = false;
    private boolean planoBooleanoActivo = false;

    public Configuracion(Plano plano) {
        this.plano = plano;
    }

    public void mostrarConfiguracion() {
        efecto.limpiarPantalla();
        while (true) {
            System.out.println(efecto.negrita("Configuración:"));
            System.out.println("1. Mostrar estadísticas e información extra: " + (plano.isEstadisticas() ? efecto.verde("Activado"):"Desactivado"));
            System.out.println("2. Mostrar el plano en términos booleanos junto a las estadísticas: " + (plano.isPlanoBooleano() ? efecto.verde("Activado"):"Desactivado"));
            System.out.println("3. Configurar caracteres del plano");
            System.out.println("4. Restablecer a caracteres predeterminados.");
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
                    mostrarPlanoBooleano();
                    break;
                case 3:
                    configurarCaracteres();
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

    // Algo innecesario pero bueno
    public void mostrarPlanoBooleano() {
        planoBooleanoActivo = !planoBooleanoActivo;
        plano.setPlanoBooleano(planoBooleanoActivo);
        if (planoBooleanoActivo) {
            System.out.println(efecto.verde("Se mostrará el plano en términos booleanos."));
        } else {
            System.out.println(efecto.verde("No se mostrará el plano en términos booleanos."));
        }
        System.out.println();
    }

    public void configurarCaracteres() {
        System.out.println(efecto.negrita("Configura tus caracteres para el plano:"));
        while (true) {
            System.out.println("Introduce el carácter para 'true: ");
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

    public void restablecerCaracteres() {
        String caracterVacio = "░░";
        String caracterLleno = "██";
        plano.setCaracterVacio(caracterVacio);
        plano.setCaracterLleno(caracterLleno);
        System.out.println(efecto.verde("Se han restablecido los caracteres."));
    }

}