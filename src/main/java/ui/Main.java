package ui;

import data.GestorDatos;
import model.Persona;
import model.Tour;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal del sistema de gestión de Llanquihue Tour.
 * Carga los tours y las personas (clientes y empleados) desde
 * archivos de texto, y permite recorrer, listar y buscar
 * registros mediante un menú simple por consola.
 */
public class Main {

    public static void main(String[] args) {

        GestorDatos gestor = new GestorDatos();
        ArrayList<Tour> tours = gestor.cargarTours();
        ArrayList<Persona> personas = gestor.cargarPersonas();

        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            mostrarMenu();

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un número válido.\n");
                continue;
            }

            switch (opcion) {
                case 1:
                    listarTours(tours);
                    break;
                case 2:
                    listarPersonas(personas);
                    break;
                case 3:
                    buscarTours(tours, scanner);
                    break;
                case 4:
                    buscarPersonas(personas, scanner);
                    break;
                case 5:
                    listarToursBajoPrecio(tours, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema. ¡Gracias por usar Llanquihue Tour!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.\n");
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("===== LLANQUIHUE TOUR - SISTEMA DE GESTIÓN =====");
        System.out.println("1. Listar todos los tours");
        System.out.println("2. Listar todas las personas (clientes y empleados)");
        System.out.println("3. Buscar tour por nombre o tipo");
        System.out.println("4. Buscar persona por nombre, RUT, cargo o tour contratado");
        System.out.println("5. Listar tours bajo un precio máximo");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void listarTours(ArrayList<Tour> tours) {
        System.out.println("\n=== CATÁLOGO COMPLETO DE TOURS ===");
        if (tours.isEmpty()) {
            System.out.println("No hay tours cargados.");
        } else {
            for (Tour t : tours) {
                System.out.println(t);
            }
        }
        System.out.println();
    }

    private static void listarPersonas(ArrayList<Persona> personas) {
        System.out.println("\n=== LISTADO DE PERSONAS ===");
        if (personas.isEmpty()) {
            System.out.println("No hay personas cargadas.");
        } else {
            for (Persona p : personas) {
                System.out.println(p);
            }
        }
        System.out.println();
    }

    private static void buscarTours(ArrayList<Tour> tours, Scanner scanner) {
        System.out.print("\nIngresa nombre o tipo de tour a buscar: ");
        String criterio = scanner.nextLine();

        System.out.println("=== RESULTADOS DE BÚSQUEDA ===");
        boolean encontrado = false;

        for (Tour t : tours) {
            if (t.coincideCon(criterio)) {
                System.out.println(t);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron tours que coincidan con '" + criterio + "'.");
        }
        System.out.println();
    }

    private static void buscarPersonas(ArrayList<Persona> personas, Scanner scanner) {
        System.out.print("\nIngresa nombre, RUT, cargo o tour a buscar: ");
        String criterio = scanner.nextLine();

        System.out.println("=== RESULTADOS DE BÚSQUEDA ===");
        boolean encontrado = false;

        for (Persona p : personas) {
            if (p.coincideCon(criterio)) {
                System.out.println(p);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron personas que coincidan con '" + criterio + "'.");
        }
        System.out.println();
    }

    private static void listarToursBajoPrecio(ArrayList<Tour> tours, Scanner scanner) {
        System.out.print("\nIngresa el precio máximo: ");

        double precioMax;
        try {
            precioMax = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Precio inválido. Operación cancelada.\n");
            return;
        }

        System.out.println("=== TOURS BAJO $" + precioMax + " ===");
        boolean encontrado = false;

        for (Tour t : tours) {
            if (t.getPrecio() < precioMax) {
                System.out.println(t.getNombre() + " - $" + t.getPrecio());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay tours bajo ese precio.");
        }
        System.out.println();
    }
}
