package com.forma;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class LeerFichero {

    Efecto efecto = new Efecto();
    private boolean esLlenado = false;
    private String caracterDeLlenado = "x";
    public Plano convertirFicheroPlano(String nombre) {
        File archivo = new File(nombre + ".txt");
        if (archivo.exists()) {
            List<String> lineas = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nombre + ".txt"), StandardCharsets.UTF_8))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    lineas.add(linea);
                }
            } catch (IOException e) {
                System.out.println(efecto.rojo("Error: No se puede leer el fichero."));
                return null;
            }

            int filas = lineas.size();
            int longitudMaxima = 0;
            for (String linea : lineas) {
                longitudMaxima = Math.max(longitudMaxima, linea.length());
            }

            String[][] matriz = new String[filas][longitudMaxima];
            Set<String> caracteres = new HashSet<>();
            for (int i = 0; i < filas; i++) {
                String linea = lineas.get(i);
                for (int j = 0; j < longitudMaxima; j++) {
                    if (j <  linea.length()) {
                        matriz[i][j] = String.valueOf(linea.charAt(j));
                        caracteres.add(matriz[i][j]);
                    } else {
                        matriz[i][j] = caracterDeLlenado;
                        esLlenado = true;
                    }
                }
            }
            return new Plano(matriz, caracteres);
        } else {
            System.out.println(efecto.rojo("Error: El archivo " + nombre + " no existe."));
            return null;
        }
    }
    // Getters y Setter
    public boolean isEsLlenado() {
        return esLlenado;
    }
    public void setEsLlenado(boolean esLlenado) {
        this.esLlenado = esLlenado;
    }
    
}