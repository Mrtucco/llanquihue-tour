package model;

import interfaces.Buscable;

/**
 * Clase abstracta que representa a una persona vinculada a la agencia
 * Llanquihue Tour. Es la superclase de Cliente y Empleado, y concentra
 * los atributos y comportamientos comunes a ambos.
 */
public abstract class Persona implements Buscable {

    private String nombre;
    private String rut;
    private String telefono;

    public Persona(String nombre, String rut, String telefono) {
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Cada subclase define su propio rol dentro de la agencia
     * (por ejemplo: "Cliente" o "Empleado - Guía turístico").
     */
    public abstract String getRol();

    /**
     * Implementación por defecto de la búsqueda: compara el criterio
     * recibido contra el nombre y el RUT de la persona, sin distinguir
     * mayúsculas o minúsculas. Cliente y Empleado pueden sobrescribir
     * este método si necesitan comparar campos adicionales.
     */
    @Override
    public boolean coincideCon(String criterio) {
        if (criterio == null) return false;
        String c = criterio.trim().toLowerCase();
        return nombre.toLowerCase().contains(c) || rut.toLowerCase().contains(c);
    }

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', rut='" + rut +
                "', telefono='" + telefono + "', rol='" + getRol() + "'}";
    }
}
