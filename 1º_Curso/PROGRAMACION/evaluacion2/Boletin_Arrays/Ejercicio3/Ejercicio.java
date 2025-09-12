package PROGRAMACION.evaluacion2.Boletin_Arrays.Ejercicio3;

import java.util.ArrayList;

public class Ejercicio {

    /**
     * Crea una colección con un tamaño en específico y valores asignados de forma
     * aleatoria entre 1000 y 5000.
     * 
     * @param size tamaño inicial que tendrá la colección.
     * @return la colección con sun contenido.
     */

    public static ArrayList<Integer> createCollection(int size) {
        ArrayList<Integer> collection = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            collection.add((int) (Math.random() * 4000 + 1000));
        }
        return collection;
    }

    /**
     * Muestra por pantalla el contenido de una colección con formato.
     * 
     * @param collection colección que queremos mostrar.
     */

    public static void showCollection(ArrayList<Integer> collection) {
        for (int index : collection) {
            System.out.printf("%s, ", index);
        }

        System.out.println();
    }

    /**
     * Muestra el valor máximo que contiene una colección.
     * 
     * @param collection colección en la cual se buscará el valor máximo.
     * @return el valor máximo de la colección.
     */

    public static int maxValue(ArrayList<Integer> collection) {
        int value = collection.get(0);

        for (int i = 0; i < collection.size(); i++) {
            if (value < collection.get(i)) {
                value = collection.get(i);
            }
        }

        return value;
    }

    /**
     * Muestra el valor mínimo que contiene una colección.
     * 
     * @param collection colección en la cual se buscará el valor minimo.
     * @return el valor mínimo de la colección.
     */

    public static int minValue(ArrayList<Integer> collection) {
        int value = collection.get(0);

        for (int col : collection) {
            if (col < value) {
                value = col;
            }
        }

        return value;
    }

    /**
     * Intercambia dos valores dados de una colección.
     * 
     * @param collection colección en la cual se intercambian los valores.
     * @param index1     valor que se intercambiará con la posición del segundo.
     * @param index2     valor que se intercambiará con la posición del primero.
     * @return false si los indices se exceden de la capacidad máxima de la
     *         colección y true si el cambio se ha realizado de forma correcta
     */

    public static boolean changeValue(ArrayList<Integer> collection, int index1, int index2) {
        if (index1 < 0 || index2 < 0 || index1 >= collection.size() || index2 >= collection.size()) {

            return false;
        } else {
            int aux = collection.get(index1);

            collection.set(index1, collection.get(index2));
            collection.set(index2, aux);

            return true;
        }
    }

    /**
     * Elimina los números mayores a uno dado de una colección.
     * 
     * @param collection es la colección en la cual se eliminarán los valores.
     * @param value      valor a partir del cual se eliminaran los valores de la
     *                   colección.
     */

    public static void deleteValues(ArrayList<Integer> collection, Integer value) {

        for (int i = collection.size() - 1; i >= 0; i--) {
            if (collection.get(i) > value) {
                collection.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> collection = createCollection(4);
        showCollection(collection);

        changeValue(collection, 2,6);

        showCollection(collection);
    }
}
