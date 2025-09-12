package app;

public class Vectores {
    public static int maxValue(int[] vector) {
        int value = vector[0];
        for (int i = 0; i < vector.length; i++) {
            if (value < vector[i]) {
                value = vector[i];
            }
        }
        return value;
    }

    public static int minValue(int[] vector) {
        int value = vector[0];
        for (int row : vector) {
            if (row < value) {
                value = row;
            }
        }
        return value;
    }

    public static boolean changeValues(int[] vector, int index1, int index2) {
        if (vector == null || index1 < 1 || index2 < 1 || index1 > vector.length || index2 > vector.length) {
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

    public static int[] ordenaVector(int[] v) {
        return null;
    }

    public static int sumaRango(int[] v, int inicio, int fin) {
        throw new UnsupportedOperationException("No implementado aún");
    }
}
