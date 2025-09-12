package PROGRAMACION.evaluacion2.Boletin_Arrays.Ejercicio4;

public class Ejercicio {

    /**
     * Muestra cada caracter de una palabra en una linea diferente.
     * 
     * @param word palabra la cual mostraremos sus caracteres.
     */

    public static void muestraEnLinea(String word) {
        for (int i = 0; i < word.length(); i++) {
            System.out.println(word.charAt(i));
        }
    }

    /**
     * Extrae e imprime una subcadena de la cadena dada comenzando en el índice
     * especificado
     * y abarcando el número de caracteres especificado.
     *
     * @param cadena        la cadena original de la cual se extrae la subcadena
     * @param inicio        el índice de inicio de la subcadena
     * @param numCaracteres el número de caracteres a incluir en la subcadena
     */

    public static void subCadena(String cadena, int inicio, int numCaracteres) {
        if (inicio > cadena.length() || numCaracteres > cadena.length()) {
            System.out.println("");
        } else {
            int largo = inicio + numCaracteres;
            for (int i = inicio; i < largo; i++) {
                System.out.print(cadena.charAt(i));
            }
            System.out.println();
        }
    }

    /**
     * Muestra una cadena centrada en la terminal.
     * 
     * @param cadena palabra o frase que queremos centrar en la terminal.
     */
    public static void muestraCentrado(String cadena) {

        int operacion = 68 - (cadena.length() / 2);
        System.out.println();

        for (int i = 0; i <= operacion; i++) {
            System.out.print(" ");
        }
        System.out.print(cadena);

        for (int i = 0; i <= operacion; i++) {
            System.out.print(" ");
        }
        System.out.println();
    }

    /**
     * Convierte una cadena de texto a un vector.
     * 
     * @param cadena cadena de texto que convertimos a vector.
     * @return el vector con los caracteres de la cadena de texto.
     */
    public static char[] cadenaAVector(String cadena) {
        char[] vector = new char[cadena.length()];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = cadena.charAt(i);
            // System.err.println(vector[i]);
        }
        return vector;
    };

    /**
     * Muestra una cadena de texto empezando por el final.
     * @param cadena es la cadena de texto que mostraremos del revés
     */
    public static String alReves(String cadena) {
        for (int i = cadena.length() - 1; i >= 0; i--) {
            cadena.charAt(i);
        }

        return cadena;
    }

    /**
     * Muestra por pantalla una cantidad indefinida de parámetros y los devuelve en mayuscula y concatenados.
     * @param cadenas son las cadenas que queremos convertir.
     * @return las cadenas en mayuscula y concatenadas.
     */

    public static String pasoAMayusculas(String... cadenas){
        StringBuilder sb = new StringBuilder();

        for(String cadena : cadenas){
            for(int i = 0; i < cadena.length(); i++){
                char letra = cadena.charAt(i);
                if(letra == '_'){
                    sb.append(' ');
                } else if(letra >= 'a' || letra <= 'z'){
                    sb.append((char) (letra - 'a' + 'A'));
                } else {
                    sb.append(letra);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
 
        System.out.println(alReves("hola"));
    }
}
