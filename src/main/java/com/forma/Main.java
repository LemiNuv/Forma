package com.forma;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Menu menu = new Menu();
        Efecto efecto = new Efecto();
        
        efecto.titulo();
        menu.menu();
    }
}