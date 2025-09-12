package examen;

public class Funciones {

    public static int[][] creaMatriz(int rows) {
        int[][] matriz = new int[rows][4];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = (int) (Math.random() * 5) + 1;
            }
        }

        return matriz;
    }

    public static void muestraMatriz(int[][] matriz) {

        String[] elements = { "A", "F", "E", "W" };

        System.out.print("     ");

        for (String row : elements) {

            System.out.printf("%2s", row);
        }

        System.out.println();

        int index1 = 0;
        for (int[] row : matriz) {
            index1++;
            System.out.printf("%3s |", index1);
            for (int column : row) {
                System.out.printf("%2s", column);
            }
            System.out.println();
        }
    }

    public static int poderDeMago(int[][] matriz, int row) {

        return matriz[row][0] + matriz[row][1] + matriz[row][2] + matriz[row][3];
    }

    public static void intercambioDePoder(int[][] matriz, int row1, int row2){

        int[] aux = matriz[row1];
        matriz[row1]= matriz[row2];
        matriz[row2] = aux;
    }
}
