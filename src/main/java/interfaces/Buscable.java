package interfaces;

/**
 * Interfaz que define el comportamiento de búsqueda para
 * cualquier entidad del sistema (Persona, Tour, etc.).
 * Permite verificar si un objeto coincide con un criterio
 * de búsqueda dado (por ejemplo, nombre, RUT, tipo).
 */
public interface Buscable {

    /**
     * Indica si el objeto coincide con el criterio de búsqueda recibido.
     *
     * @param criterio texto a buscar (no distingue mayúsculas/minúsculas)
     * @return true si el objeto coincide con el criterio, false en caso contrario
     */
    boolean coincideCon(String criterio);
}
