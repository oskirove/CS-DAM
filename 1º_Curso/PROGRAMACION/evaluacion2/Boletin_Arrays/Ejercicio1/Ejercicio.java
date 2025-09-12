package PROGRAMACION.evaluacion2.Boletin_Arrays.Ejercicio1;

public class Ejercicio {

    /**
     * Función que crea un vector cuyo contenido son números aleatorios entre 1000 y
     * 5000.
     * 
     * @param n capacidad máxima del vector
     * @return vector con números aleatorios
     */

    public static int[] createRandomVector(int n) {

        int[] vector = new int[n];

        for (int i = 0; i < n; i++) {
            vector[i] = (int) (Math.random() * 4001 + 1000);
        }

        return vector;
    }

    /**
     * Función que muestra por pantalla el contenido de un vector de enteros.
     * 
     * @param vector vector a mostrar
     */

    public static void showRandomVector(int[] vector) {

        int rowIndex = -1;
        for (int row : vector) {
            rowIndex++;
            System.out.printf("Índice %s: %s%n", rowIndex, row);
        }
    }

    /**
     * Función que devuelve el valor máximo de un vector de enteros.
     * 
     * @param vector vector a comprobar
     * @return valor máximo del vector
     */
    public static int maxValue(int[] vector) {

        int value = vector[0];
        for (int i = 0; i < vector.length; i++) {
            if (value < vector[i]) {
                value = vector[i];
            }
        }
        return value;
    }

    /**
     * Función que devuelve el valor mínimo de un vector de enteros.
     * 
     * @param vector vector a comprobar
     * @return valor mínimo del vector
     */

    public static int minValue(int[] vector) {
        int value = vector[0];
        for (int row : vector) {
            if (row < value) {
                value = row;
            }
        }
        return value;
    }

    /**
     * Función que devuelve la media de los valores de un vector de enteros.
     * @param vector vector a comprobar
     * @param index1 indice a intercambiar por el indice 2
     * @param index2 indice a intercambiar por el indice 1
     * @return true si se ha realizado el intercambio de valores y false di no se da el caso.
     */
    public static boolean changeValues(int[] vector, int index1, int index2) {

        if (index1 < 1 || index2 < 1 || index1 > vector.length || index2 > vector.length) {
            return false;
        } else {
            index1--;
            index2--;
            int auxvar = vector[index1];
            vector[index1] = vector[index2];
            vector[index2] = auxvar;

            return true;
        }
    }

    public static void main(String[] args) {

        int[] vector = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int row : vector) {
            System.out.printf("%s, ", row);
        }
        System.out.println();

        changeValues(vector, 2, 3);

        for (int row : vector) {
            System.out.printf("%s, ", row);
        }
        System.out.println();
    }
}
