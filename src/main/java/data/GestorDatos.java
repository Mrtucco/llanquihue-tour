package data;

import model.Tour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GestorDatos {

    public ArrayList<Tour> cargarTours() {

        ArrayList<Tour> listaTours = new ArrayList<>();

        try (InputStream is = GestorDatos.class
                .getClassLoader()
                .getResourceAsStream("tours.txt");
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(is, "UTF-8"))) {

            String linea;
            while ((linea = reader.readLine()) != null) {

                if (linea.trim().isEmpty()) continue;

                String[] campos = linea.split(";");

                if (campos.length == 3) {
                    String nombre = campos[0].trim();
                    String tipo   = campos[1].trim();
                    double precio = Double.parseDouble(campos[2].trim());
                    listaTours.add(new Tour(nombre, tipo, precio));
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("No se encontró tours.txt en resources/");
        }

        return listaTours;
    }
}