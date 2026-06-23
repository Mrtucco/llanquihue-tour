package model;

import interfaces.Buscable;

/**
 * Representa un tour ofrecido por la agencia Llanquihue Tour
 * (ej: ruta gastronómica, paseo lacustre, excursión cultural).
 * Se mantiene la estructura original de la Evaluación 1 y se
 * agrega la implementación de la interfaz Buscable para
 * permitir búsquedas por nombre o tipo.
 */
public class Tour implements Buscable {

    private String nombre;
    private String tipo;
    private double precio;

    public Tour(String nombre, String tipo, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Permite buscar un tour por nombre o por tipo, sin distinguir
     * mayúsculas o minúsculas.
     */
    @Override
    public boolean coincideCon(String criterio) {
        if (criterio == null) return false;
        String c = criterio.trim().toLowerCase();
        return nombre.toLowerCase().contains(c) || tipo.toLowerCase().contains(c);
    }

    @Override
    public String toString() {
        return "Tour{nombre='" + nombre + "', tipo='" + tipo +
                "', precio=$" + precio + "}";
    }
}
