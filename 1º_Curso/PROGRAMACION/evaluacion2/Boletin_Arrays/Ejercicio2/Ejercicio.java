package PROGRAMACION.evaluacion2.Boletin_Arrays.Ejercicio2;

public class Ejercicio {

    /**
     * Función que crea una tabla de caracteres con letras aleatorias.
     * 
     * @param rows    El número de filas que va a tener la tabla.
     * @param columns El número de columnas que va a tener la tabla.
     * @return La tabla de caracteres.
     */

    public static char[][] createTable(int rows, int columns) {

        char[][] table = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                table[i][j] = (char) (Math.random() * 26 + 'A');
            }
        }
        return table;
    }

    /**
     * Función que muestra por pantalla un array en formato de tabla.
     * 
     * @param table El array a mostrar
     */
    public static void showTable(char[][] table) {
        System.out.print("   ");
        for (int i = 0; i < table[0].length; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();

        for (int i = 0; i < table.length; i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%2s ", table[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Función que devuelve el valor máximo de un array de caracteres.
     * 
     * @param table array a comprobar
     * @return valor máximo del array
     */
    public static int maxValue(char[][] table) {

        char value = table[0][0];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (value < table[i][j]) {
                    value = table[i][j];
                }
            }
        }
        return value;
    }

    /**
     * Función que devuelve el valor mínimo de un array de caracteres.
     * 
     * @param table array a comprobar
     * @return valor mínimo del array
     */

    public static int minValue(char[][] table) {
        char value = table[0][0];
        for (char[] row : table) {
            for(char column : row){
                if (column < value) {
                    value = column;
                }
            }
        }
        return value;
    }

    /**
     * Función que intercambia los valores de dos posiciones de una matriz.
     * 
     * @param matriz el array en el que se van a intercambiar los valores.
     * @param row1   la fila del primer valor a intercambiar.
     * @param col1   la columna del primer valor a intercambiar.
     * @param row2   la fila del segundo valor a intercambiar.
     * @param col2   la columna del segundo valor a intercambiar
     * @return true si se ha podido intercambiar los valores y false si no se ha
     *         cumplido el cambio.
     */

    public static boolean changeValues(char[][] matriz, int row1, int col1, int row2, int col2) {
        int numRows = matriz.length;
        int numCols = matriz[0].length;

        if (row1 < 0 || row1 >= numRows || row2 < 0 || row2 >= numRows || col1 < 0 || col1 >= numCols || col2 < 0 || col2 >= numCols) {
            return false;
        } else {
            char aux = matriz[row1][col1];
            matriz[row1][col1] = matriz[row2][col2];
            matriz[row2][col2] = aux;
            return true;
        }
    }

    public static void main(String[] args) {

        char[][] table = createTable(3, 3);
        System.out.println();
        showTable(table);
        System.out.println();
        System.out.printf(" El valor mas alto es: %s%n", (char) maxValue(table));
        System.out.printf(" El valor mas bajo es: %s%n", (char) minValue(table));
        System.out.println();
       // changeValues(table, -1, 0, 0, 0);
        changeValues(table, -1, 0, 0, 0);
    }
}
