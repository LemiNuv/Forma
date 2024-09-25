package com.forma;
import java.util.Scanner;
// Así para hacerlo más bonito :D
public class Efecto {
    // Estilos de texto
    public static final String NEGRITA = "\033[1m";
    public static final String RESET = "\033[0m";
    public static final String ITALICA = "\033[3m";
    public static final String ITALICA_RESET = "\033[23m";
    public static final String SUBRAYADO = "\033[4m";
    public static final String SUBRAYADO_RESET = "\033[24m";
    public static final String PARPADEANTE = "\033[5m";
    public static final String PARPADEANTE_RESET = "\033[25m";
    public static final String INVERTIR_C = "\033[7m";
    public static final String INVERTIR_RESET = "\033[27m";
    public static final String TACHADO = "\033[9m";
    public static final String TACHADO_RESET = "\033[29m";
    // Colores -- Gracias WhiteFang34!
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    // Backgrounds colors
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public void titulo() {
        limpiarPantalla();
        System.out.println("\r\n" + //
                        " _|_|_|_|                                              \r\n" + //
                        " _|        _|_|    _|  _|_|  _|_|_|  _|_|      _|_|_|  \r\n" + //
                        " _|_|_|  _|    _|  _|_|      _|    _|    _|  _|    _|  \r\n" + //
                        " _|      _|    _|  _|        _|    _|    _|  _|    _|  \r\n" + //
                        " _|        _|_|    _|        _|    _|    _|    _|_|_|  \r\n" + //
                        "                                                       \r\n" + //
                        "" + ITALICA + "by lemi" + ITALICA_RESET + "            \r\n" + //
                        "");
        esperarAlUsuarioIntro();
    }
    
    public void saltoDeLinea() {
        System.out.println();
    }

    public void separadoresConEspacio(int espacios, int columnas) {
        for (int i = 0; i < espacios; i++) System.out.print("\s");
        for (int i = 0; i < columnas; i++) System.out.print("═");
        System.out.println();
    }

    public void separadoresConEspacioParaAleatorio(int espacios, int columnas) {
        for (int i = 0; i < espacios; i++) System.out.print("\s");
        for (int i = 0; i < columnas; i++) System.out.print("══");
        System.out.println();
    }

    public void separadoresConGuion(int espacios, int columnas) {
        for (int i = 0; i < espacios; i++) System.out.print("\s");
        for (int i = 0; i < columnas; i++) System.out.print("-");
        System.out.println();
    }

    public void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void descanso(int tiempo) {
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void esperarAlUsuario() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nPresiona Enter para continuar...");
        in.nextLine();
    }

    public void esperarAlUsuarioIntro() {
        Scanner in = new Scanner(System.in);
        String inicio = cursiva("Presiona Enter para continuar...");
        boolean[] enterPresionado = {false};

        Thread inputThread = new Thread(() -> {
            in.nextLine();
            enterPresionado[0] = true;
        });
        inputThread.start();

        for (char c : inicio.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (enterPresionado[0]) {
                break;
            }
        }
        try {
            inputThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println();
    }
    // Colorear frases
    public String negrita(String frase) {
        return NEGRITA + frase + RESET;
    }
    public String cursiva(String frase) {
        return ITALICA + frase + ITALICA_RESET;
    }
    public String rojo(String frase) {
        return ANSI_RED + frase + ANSI_RESET;
    }
    public String verde(String frase) {
        return ANSI_GREEN + frase + ANSI_RESET;
    }
    public String amarillo(String frase) {
        return ANSI_YELLOW + frase + ANSI_RESET;
    }
    public String cyan(String frase) {
        return ANSI_CYAN + frase + ANSI_RESET;
    }
}