package arrays;

public class Matriz {
    private int[][] matriz;

    public Matriz(int size) {
        this.matriz = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matriz[i][j] = (int) (Math.random() * 11);
            }
        }
    }

    public static void showArray(int[][] matriz) {
        
        int index1 = -1;
        int index2 = -1;
        System.out.print("   ");
        for (int[] row : matriz) {
            index2++;
            System.out.printf("%3s", index2);
        }

        System.out.println();

        for (int[] row : matriz) {
            index1++;
            System.out.printf("%s |", index1);
            for (int column : row) {
                System.out.printf("%3s", column);
            }
            System.out.println();
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int suma() {
        int suma = 0;

        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++){
                suma +=matriz[i][j];
            }
        }

        return suma;
    }

    public int suma(boolean trigger) {
        
        if(trigger == true) {
            for(int i = 0; i < matriz.length; i++){
                for(int j = i; j > i;){
                    System.out.print("*");
                }
            }
        } else {

        }

        return 0;
    }
}
