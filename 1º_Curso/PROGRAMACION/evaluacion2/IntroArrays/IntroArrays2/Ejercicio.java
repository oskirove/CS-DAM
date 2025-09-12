package PROGRAMACION.evaluacion2.IntroArrays.IntroArrays2;

public class Ejercicio {

    public static double[][] createArray(int rows, int columns) {

        double[][] table = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                table[i][j] = Math.random() * 10 + 20;
            }
        }

        return table;
    }

    public static void showArray(int rows, int columns) {
        double[][] table = createArray(rows, columns);

        int rowIndex = 0;
        int columnIndex = 0;

        for (int i = 0; i < columns; i++){
            System.out.printf("%8s", columnIndex++);
        }
        System.out.println();

        for (double[] row : table) {
            System.out.printf("%4d |", rowIndex++);
            for (double value : row) {
                System.out.printf("%6.2f |", value);
            }
            System.out.println();
        }
    };

    public static void main(String[] args) {
        showArray(15, 13);
    };
}
