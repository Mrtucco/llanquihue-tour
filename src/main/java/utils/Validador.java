package utils;

/**
 * Clase utilitaria con métodos estáticos de validación.
 * Se usa antes de crear o cargar objetos del sistema para
 * evitar datos inválidos o duplicados.
 */
public class Validador {

    // Evita que se instancie esta clase, ya que solo contiene métodos estáticos.
    private Validador() {
    }

    /**
     * Valida que un texto no sea nulo ni esté vacío.
     */
    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /**
     * Valida un RUT chileno en formato simple (ej: 12345678-9).
     * No calcula el dígito verificador, solo valida estructura básica.
     */
    public static boolean esRutValido(String rut) {
        if (!esTextoValido(rut)) return false;
        return rut.matches("\\d{7,8}-[0-9kK]");
    }

    /**
     * Valida que un número (precio, sueldo, etc.) sea mayor a cero.
     */
    public static boolean esNumeroPositivo(double valor) {
        return valor > 0;
    }

    /**
     * Convierte un texto a double de forma segura.
     * Retorna -1 si el texto no es un número válido.
     */
    public static double parseDoubleSeguro(String texto) {
        try {
            return Double.parseDouble(texto.trim());
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Valor numérico inválido: '" + texto + "'");
            return -1;
        }
    }

    /**
     * Convierte un texto a int de forma segura.
     * Retorna -1 si el texto no es un número entero válido.
     */
    public static int parseIntSeguro(String texto) {
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Valor entero inválido: '" + texto + "'");
            return -1;
        }
    }
}
