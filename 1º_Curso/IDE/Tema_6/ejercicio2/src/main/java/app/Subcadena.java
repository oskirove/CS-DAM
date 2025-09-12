package app;

public class Subcadena {
    public static String subCadena(String cadena, int inicio, int numCaracteres) {
        if (cadena == null) {
            throw new IllegalArgumentException("La cadena no puede ser null.");
        }

        if (inicio < 0 || numCaracteres < 0) {
            throw new IllegalArgumentException("Inicio y número de caracteres deben ser positivos.");
        }

        if (inicio + numCaracteres > cadena.length()) {
            throw new IndexOutOfBoundsException("La subcadena se sale del rango.");
        }

        return cadena.substring(inicio, inicio + numCaracteres);
    }
}
