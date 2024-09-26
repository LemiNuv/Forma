package com.forma;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class EscribirFichero {
    private Plano plano;
    Efecto efecto = new Efecto();

    public EscribirFichero(Plano plano) {
        this.plano = plano;
    }

    public void preguntarNombre() {
        Scanner in = new Scanner(System.in);
        System.out.println(efecto.negrita("¿Nombre para tu fichero?"));
        String nombre = in.nextLine();
        escribirFichero(nombre);
    }

    public void escribirFichero(String nombre) {
        File archivo = new File(nombre + ".txt");
        if (archivo.exists()) {
            System.out.println(efecto.rojo("Error: El archivo " + nombre + " ya existe."));
            System.out.println(efecto.amarillo("Warning: Si decides continuar se sobreescribirá el contenido del archivo " + archivo));
            System.out.println(efecto.negrita("¿Desea continuar? (s/n)"));

            Scanner in = new Scanner(System.in);
            String respuesta = in.nextLine();
            if (respuesta.length() == 1 && respuesta.equalsIgnoreCase("s")) {
                System.out.println(efecto.amarillo("Se sobreescribirá el archivo " + archivo));
            } else {
                System.out.println(efecto.verde("Operación cancelada."));
                return;
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), StandardCharsets.UTF_8))) {
            for (int i = 0; i < plano.getFilas(); i++) {
                for (int j = 0; j < plano.getColumnas(); j++) {
                    bw.write(plano.getPlano()[i][j]);
                }
                bw.newLine();
            }
            System.out.println(efecto.verde("Plano guardado exitosamente."));
        } catch (Exception e) {
            System.out.println(efecto.rojo("Error al guardar el archivo."));
        }
    } 
}
