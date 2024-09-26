package com.forma;
import java.util.InputMismatchException;
import java.util.Scanner;;

public class Menu {
    private Plano plano;
    private Efecto efecto;
    private LeerFichero leerFichero;
    private Configuracion configuracion;

    public Menu() {
        leerFichero = new LeerFichero();
        plano = new Plano(leerFichero);
        configuracion = new Configuracion(plano, leerFichero);
        efecto = new Efecto();
    }
    
    public void menu() {
        Scanner in = new Scanner(System.in);
        efecto.limpiarPantalla();
        while (true) {
            System.out.println(efecto.cursiva("Forma v1.1.0"));
            System.out.println(efecto.negrita("Menu:"));
            System.out.println("1. Generar plano");
            System.out.println("2. Guardar plano anterior en un archivo.");
            System.out.println("3. Configuración");
            System.out.println("4. Salir");
            System.out.println("Selecciona una opción:");
            int opcion = -1;
            try {
                opcion = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(efecto.rojo("Error: Debes ingresar un número."));
                in.next();
                continue;
            }
            switch (opcion) {
                case 1:
                    plano.opcion();                
                    break;
                case 2:
                    EscribirFichero fichero = new EscribirFichero(plano);
                    fichero.preguntarNombre();
                    break;
                case 3:
                    configuracion.mostrarConfiguracion();
                    break;
                case 4:
                    System.out.println(efecto.verde("Saliendo..."));
                    in.close();
                    return;
                default:
                    System.out.println(efecto.rojo("Opción no válida. Por favor selecciona una opción válida."));
                    break;
            }
        }
    }
}