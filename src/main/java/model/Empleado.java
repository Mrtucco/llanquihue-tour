package model;

/**
 * Representa a un empleado de la agencia Llanquihue Tour
 * (por ejemplo: guía turístico, operador o administrativo).
 * Extiende Persona agregando el cargo y el sueldo base.
 */
public class Empleado extends Persona {

    private String cargo;
    private double sueldoBase;

    public Empleado(String nombre, String rut, String telefono,
                     String cargo, double sueldoBase) {
        super(nombre, rut, telefono);
        this.cargo = cargo;
        this.sueldoBase = sueldoBase;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    @Override
    public String getRol() {
        return "Empleado - " + cargo;
    }

    /**
     * Para un empleado, además de nombre y RUT, también se puede
     * buscar por su cargo (ej: "guía", "operador").
     */
    @Override
    public boolean coincideCon(String criterio) {
        if (criterio == null) return false;
        String c = criterio.trim().toLowerCase();
        return super.coincideCon(criterio) || cargo.toLowerCase().contains(c);
    }

    @Override
    public String toString() {
        return "Empleado{nombre='" + getNombre() + "', rut='" + getRut() +
                "', telefono='" + getTelefono() + "', cargo='" + cargo +
                "', sueldoBase=$" + sueldoBase + "}";
    }
}
