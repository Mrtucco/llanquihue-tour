package model;

/**
 * Representa a un cliente de la agencia Llanquihue Tour.
 * Extiende Persona agregando los datos propios de un cliente:
 * el tour contratado y la cantidad de personas que viajan con él.
 */
public class Cliente extends Persona {

    private String tourContratado;
    private int cantidadPersonas;

    public Cliente(String nombre, String rut, String telefono,
                    String tourContratado, int cantidadPersonas) {
        super(nombre, rut, telefono);
        this.tourContratado = tourContratado;
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getTourContratado() {
        return tourContratado;
    }

    public void setTourContratado(String tourContratado) {
        this.tourContratado = tourContratado;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    @Override
    public String getRol() {
        return "Cliente";
    }

    /**
     * Para un cliente, además de nombre y RUT, también se puede
     * buscar por el nombre del tour que contrató.
     */
    @Override
    public boolean coincideCon(String criterio) {
        if (criterio == null) return false;
        String c = criterio.trim().toLowerCase();
        return super.coincideCon(criterio) || tourContratado.toLowerCase().contains(c);
    }

    @Override
    public String toString() {
        return "Cliente{nombre='" + getNombre() + "', rut='" + getRut() +
                "', telefono='" + getTelefono() + "', tourContratado='" + tourContratado +
                "', cantidadPersonas=" + cantidadPersonas + "}";
    }
}
