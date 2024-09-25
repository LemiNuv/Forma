package com.forma;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Set;

public class Plano {

    Efecto efecto = new Efecto();
    Scanner in = new Scanner(System.in);
    LeerFichero leer = new LeerFichero();
    StringBuilder bui = new StringBuilder();

    Set<String> caracteres;
    private long semilla;
    private int filas;
    private int columnas;
    private String caracterVacio = "░░";
    private String caracterLleno = "██";
    private String[][] plano;
    private Random random;
    private boolean estadisticas = false;
    private boolean planoBooleano = false;
    private boolean semillaAleatoria = false;

    public Plano(String[][] matriz, Set<String> caracteres) {
        this.filas = matriz.length;
        this.columnas = matriz[0].length;
        this.plano = matriz;
        this.caracteres = caracteres;
    }

    public Plano() {
        filas = 13;
        columnas = 40;
        plano = new String[filas][columnas];
        String[][] planoDefault = {
            {"░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░"},
            {"░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "█", "█", "█", "█", "█", "█", "█", "█", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░"},
            {"░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "█", "█", "░", "░", "░", "░", "░", "░", "░", "░", "▓", "█", "░", "░", "░", "░", "░", "░", "░", "░", "░"},
            {"░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "█", "░", "░", "░", "░", "░", "▒", "▒", "░", "░", "░", "░", "░", "█", "░", "░", "░", "░", "░", "░", "░", "░"},
            {"░", "░", "░", "░", "░", "░", "░", "░", "▓", "█", "█", "█", "█", "█", "█", "█", "█", "░", "░", "░", "░", "░", "░", "▒", "█", "▓", "░", "░", "░", "░", "░", "░", "█", "░", "░", "░", "░", "░", "░", "░"},
            {"░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "▒", "█", "█", "▒", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "░", "░", "░", "░", "░", "░", "░"},
            {"░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "█", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "░", "░", "░", "░", "░", "░", "░"},
            {"░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "░", "░", "░", "░", "░", "░", "░"},
            {"░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "█", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "█", "░", "░", "░", "░", "░", "░", "░"},
            {"░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "░", "░", "░", "░", "░", "░", "░", "░"},
            {"░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "█", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "░", "░", "░", "░", "░", "░", "░", "░"},
            {"░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "▒", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "▒", "░", "░", "░", "░", "░", "░", "░", "░"},
            {"l", "e", "m", "i", "░", "░", "░", "░", "░", "░", "░", "█", "▒", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "░", "█", "░", "░", "░", "░", "░", "░", "░", "░", "░"},
        };
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                plano[i][j] = planoDefault[i][j];
            }
        }
    }

    public void opcion() {
        efecto.limpiarPantalla();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println(efecto.negrita("Opciones para el plano:"));
            System.out.println("1. Generar plano con semilla aleatoria.");
            System.out.println("2. Cargar un plano desde un archivo " + efecto.cursiva("(un archivo \".txt\")") + ".");
            System.out.println("3. Regresar al menú principal.");
            int opcion = -1;
            try {
                opcion = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(efecto.rojo("Error: Opción no válida."));
                in.next();
                continue;
            }
            switch (opcion) {
                case 1:
                    this.semillaAleatoria = true;
                    preguntarDetalles();
                    efecto.esperarAlUsuario();
                    efecto.limpiarPantalla();
                    break;
                case 2:
                    this.semillaAleatoria = false;
                    cargarDesdeUnFichero();
                    efecto.esperarAlUsuario();
                    efecto.limpiarPantalla();
                    break;
                case 3:
                    efecto.limpiarPantalla();
                    return;
                default:
                    System.out.println(efecto.rojo("Error: Opción no válida."));
                    break;
            }
        }
    }

    public void cargarDesdeUnFichero() {
        efecto.limpiarPantalla();
        Scanner in = new Scanner(System.in);
        System.out.println("Escribe el " + efecto.cyan("nombre") +" o " + efecto.cyan("ruta") + " del fichero a convertir:");
        String nombre = in.nextLine().trim();
        if (nombre.contains(".")) {
            String[] partes = nombre.split("\\.");
            nombre = partes[0];
            System.out.println(efecto.amarillo("Warning: No es necesario escribir el \".txt\""));
        }
        Plano nuevoPlano = leer.convertirFicheroPlano(nombre);
        if (nuevoPlano != null) {
            this.filas = nuevoPlano.filas;
            this.columnas = nuevoPlano.columnas;
            this.plano = nuevoPlano.plano;
            this.caracteres = nuevoPlano.caracteres;
        } else return;
        System.out.println(efecto.cursiva(efecto.negrita("Imprimiendo...")));
        imprimirPlano();
    }

    public void preguntarDetalles() {
        efecto.limpiarPantalla();
        while (true) {
            try {
                System.out.println(efecto.negrita("Semilla para generar el plano (entero):"));
                this.semilla = in.nextLong();
                this.random = new Random(semilla);
                break;
            } catch (InputMismatchException e) {
                System.out.println(efecto.rojo("Error: La semilla debe ser un número entero."));
                in.next();
            }
        }
        while (true) {
            try {
                System.out.println(efecto.negrita("Tamaño del plano (entero para filas):"));
                this.filas = in.nextInt();
                if (filas <= 0) {
                    System.out.println(efecto.rojo("Error: El tamaño debe ser un número entero positivo."));
                    continue;
                }
                System.out.println(efecto.negrita("Tamaño del plano (entero para columnas):"));
                this.columnas = in.nextInt();
                if (columnas <= 0) {
                    System.out.println(efecto.rojo("Error: El tamaño debe ser un número entero positivo."));
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                    System.out.println(efecto.rojo("Error: El tamaño debe ser un número entero positivo."));
                    in.next();
            }
        }
        generarPlano();
        imprimirPlano();
        in.nextLine();

        while (true) {
            System.out.println();
            System.out.println(efecto.negrita("¿Quieres guardar en plano generado en un archivo? (s/n):"));
            String respuesta = in.nextLine();
            if (respuesta.length() == 1) {
                if (respuesta.equalsIgnoreCase("s")) {
                    EscribirFichero fichero = new EscribirFichero(this);
                    fichero.preguntarNombre();
                    break;
                } else {
                    System.out.println(efecto.verde("No se guardará el plano."));
                    break;
                }
            } else {
                System.out.println(efecto.rojo("Error: Introduce solo 's' o 'n'"));
            }
        }
    }

    public void generarPlano() {
        this.plano = new String[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                plano[i][j] = random.nextBoolean() ? caracterVacio:caracterLleno;
            }
        }
    }

    public int contarCeldasLlenas() {
        int lleno = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (plano[i][j] == caracterLleno) {
                    lleno++;
                }
            }
        }
        return lleno;
    }

    public int contarCeldasVacias() {
        int vacio = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (plano[i][j] == caracterVacio) {
                    vacio++;
                }
            }
        }
        return vacio;
    }

    public void planoBooleano() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (plano[i][j] == caracterVacio) bui.append("true").append(" ");
                if (plano[i][j] == caracterLleno) bui.append("false").append(" ");
            }
            bui.append("\n");
        }
    }

    public void imprimirPlano() {
        if (semillaAleatoria) {
            efecto.separadoresConEspacioParaAleatorio(0, columnas);
        } else efecto.separadoresConEspacio(0, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(plano[i][j]);
            }
            System.out.println();
        }
        if (!estadisticas) {
            if (semillaAleatoria){
                efecto.separadoresConEspacioParaAleatorio(0, columnas);
            } else efecto.separadoresConEspacio(0, columnas);
        }
        if (estadisticas) obtenerEstadisticas();
    }

    public void obtenerEstadisticas() {
        int lleno = contarCeldasLlenas();
        int vacio = contarCeldasVacias();
        double totalCeldas = filas*columnas;
        double porcentajeLleno = (double) lleno / totalCeldas * 100;
        double porcentajeVacio = (double) vacio / totalCeldas * 100;
        efecto.separadoresConEspacio(0, columnas);
        efecto.separadoresConGuion(0, columnas);
        if (semillaAleatoria) System.out.println("Leyenda:\n" + "- " + caracterVacio + " es true\n- " + caracterLleno + " es false");
        System.out.printf("Total de celdas: [%d]\n", (filas*columnas));
        System.out.printf("Número de filas: [%d]\n", filas);
        System.out.printf("Número de columnas: [%d]\n", columnas);
        if (!semillaAleatoria){
            System.out.println("Caracteres encontrados:");
            for (String caracter : caracteres) {
                System.out.println("- " + caracter);
            }
        }
        if (semillaAleatoria) System.out.printf("Celdas pintadas (%s): [%d]\n", caracterLleno, lleno);
        if (semillaAleatoria) System.out.printf("Celdas vacías (%s): [%d]\n", caracterVacio, vacio);
        if (semillaAleatoria) System.out.println("Porcentaje de celdas llenas: [" + String.format("%.2f", porcentajeLleno) + "%]");
        if (semillaAleatoria) System.out.println("Porcentaje de celdas vacías: [" + String.format("%.2f", porcentajeVacio) + "%]");
        if (semillaAleatoria) System.out.println("Semilla utilizada: [" + semilla + "]");
        if (semillaAleatoria) System.out.println("Hash de la semilla: [" + Long.hashCode(semilla) + "]");
        if (planoBooleano) {
            planoBooleano();
            for (int i = 0; i < columnas; i++) System.out.print("---");
            System.out.println();
            System.out.println("Plano en términos booleanos: ");
            System.out.println(bui.toString());
        }
        // Avisos y demás
        efecto.separadoresConGuion(0, columnas);
        if (!semillaAleatoria) System.out.println(efecto.cyan("Information: Cada carácter se cuenta como una columna."));
        if (leer.isEsLlenado() == true) System.out.println(efecto.cyan("Algunas filas eran más cortas que la longitud máxima, por lo que han rellenado con caráteres adicionales para compensarlo. " + efecto.negrita("Este relleno no afecta los datos originales, solo asegura la integridad de la matriz generada.")));
        leer.setEsLlenado(false);
        bui.setLength(0);
        this.semillaAleatoria = false;
    }
    //Getters y Setters
    public String getCaracterVacio() {
        return caracterVacio;
    }
    public void setCaracterVacio(String caracterVacio) {
        this.caracterVacio = caracterVacio;
    }
    public String getCaracterLleno() {
        return caracterLleno;
    }
    public void setCaracterLleno(String caracterLleno) {
        this.caracterLleno = caracterLleno;
    }
    public boolean isEstadisticas() {
        return estadisticas;
    }
    public void setEstadisticas(boolean estadisticas) {
        this.estadisticas = estadisticas;
    }
    public boolean isPlanoBooleano() {
        return planoBooleano;
    }
    public void setPlanoBooleano(boolean planoBooleano) {
        this.planoBooleano = planoBooleano;
    }
    public int getFilas() {
        return filas;
    }
    public void setFilas(int filas) {
        this.filas = filas;
    }
    public int getColumnas() {
        return columnas;
    }
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    public String[][] getPlano() {
        return plano;
    }
    public Set<String> getCaracteres() {
        return caracteres;
    }
}
