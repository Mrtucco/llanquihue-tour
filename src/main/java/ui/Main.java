package ui;

import data.GestorDatos;
import model.Tour;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        GestorDatos gestor = new GestorDatos();
        ArrayList<Tour> tours = gestor.cargarTours();


        System.out.println("=== CATÁLOGO COMPLETO ===");
        for (Tour t : tours) {
            System.out.println(t);
        }


        System.out.println("\n=== TOURS GASTRONÓMICOS ===");
        for (Tour t : tours) {
            if (t.getTipo().equalsIgnoreCase("gastronómico")) {
                System.out.println(t.getNombre() + " - $" + t.getPrecio());
            }
        }


        System.out.println("\n=== TOURS BAJO $40.000 ===");
        for (Tour t : tours) {
            if (t.getPrecio() < 40000) {
                System.out.println(t.getNombre() + " - $" + t.getPrecio());
            }
        }
    }
}