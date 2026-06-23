package data;

import model.Cliente;
import model.Empleado;
import model.Persona;
import model.Tour;
import utils.Validador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Clase encargada de leer los archivos de texto ubicados en
 * resources/ y transformar cada línea en objetos del sistema
 * (Tour, Cliente, Empleado), aplicando validaciones básicas.
 */
public class GestorDatos {

    /**
     * Carga el catálogo de tours desde el archivo tours.txt.
     * Formato esperado por línea: nombre;tipo;precio
     */
    public ArrayList<Tour> cargarTours() {

        ArrayList<Tour> listaTours = new ArrayList<>();

        try (InputStream is = GestorDatos.class
                .getClassLoader()
                .getResourceAsStream("tours.txt");
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(is, "UTF-8"))) {

            String linea;
            int numeroLinea = 0;

            while ((linea = reader.readLine()) != null) {
                numeroLinea++;

                if (linea.trim().isEmpty()) continue;

                String[] campos = linea.split(";");

                if (campos.length != 3) {
                    System.out.println("Línea " + numeroLinea + " inválida en tours.txt (se esperaban 3 campos): " + linea);
                    continue;
                }

                try {
                    String nombre = campos[0].trim();
                    String tipo = campos[1].trim();
                    double precio = Validador.parseDoubleSeguro(campos[2]);

                    if (!Validador.esTextoValido(nombre) || !Validador.esTextoValido(tipo)
                            || !Validador.esNumeroPositivo(precio)) {
                        System.out.println("Datos inválidos en línea " + numeroLinea + " de tours.txt: " + linea);
                        continue;
                    }

                    listaTours.add(new Tour(nombre, tipo, precio));

                } catch (Exception e) {
                    System.out.println("Error procesando línea " + numeroLinea + " de tours.txt: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo tours.txt: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("No se encontró tours.txt en resources/");
        }

        return listaTours;
    }

    /**
     * Carga la lista de personas (clientes y empleados) desde
     * el archivo personas.txt.
     * Formato esperado por línea:
     *   CLIENTE;nombre;rut;telefono;tourContratado;cantidadPersonas
     *   EMPLEADO;nombre;rut;telefono;cargo;sueldoBase
     */
    public ArrayList<Persona> cargarPersonas() {

        ArrayList<Persona> listaPersonas = new ArrayList<>();

        try (InputStream is = GestorDatos.class
                .getClassLoader()
                .getResourceAsStream("personas.txt");
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(is, "UTF-8"))) {

            String linea;
            int numeroLinea = 0;

            while ((linea = reader.readLine()) != null) {
                numeroLinea++;

                if (linea.trim().isEmpty()) continue;

                String[] campos = linea.split(";");

                if (campos.length != 6) {
                    System.out.println("Línea " + numeroLinea + " inválida en personas.txt (se esperaban 6 campos): " + linea);
                    continue;
                }

                try {
                    String tipoPersona = campos[0].trim().toUpperCase();
                    String nombre = campos[1].trim();
                    String rut = campos[2].trim();
                    String telefono = campos[3].trim();

                    if (!Validador.esTextoValido(nombre) || !Validador.esRutValido(rut)) {
                        System.out.println("Datos inválidos en línea " + numeroLinea + " de personas.txt: " + linea);
                        continue;
                    }

                    if (tipoPersona.equals("CLIENTE")) {
                        String tourContratado = campos[4].trim();
                        int cantidadPersonas = Validador.parseIntSeguro(campos[5]);

                        if (cantidadPersonas <= 0) {
                            System.out.println("Cantidad de personas inválida en línea " + numeroLinea + ": " + linea);
                            continue;
                        }

                        listaPersonas.add(new Cliente(nombre, rut, telefono, tourContratado, cantidadPersonas));

                    } else if (tipoPersona.equals("EMPLEADO")) {
                        String cargo = campos[4].trim();
                        double sueldoBase = Validador.parseDoubleSeguro(campos[5]);

                        if (!Validador.esNumeroPositivo(sueldoBase)) {
                            System.out.println("Sueldo inválido en línea " + numeroLinea + ": " + linea);
                            continue;
                        }

                        listaPersonas.add(new Empleado(nombre, rut, telefono, cargo, sueldoBase));

                    } else {
                        System.out.println("Tipo de persona desconocido en línea " + numeroLinea + ": " + tipoPersona);
                    }

                } catch (Exception e) {
                    System.out.println("Error procesando línea " + numeroLinea + " de personas.txt: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo personas.txt: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("No se encontró personas.txt en resources/");
        }

        return listaPersonas;
    }
}
