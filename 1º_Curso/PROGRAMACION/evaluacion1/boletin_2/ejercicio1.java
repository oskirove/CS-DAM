/*
a) Realiza un programa que muestre los números del 1 al 20. Debes hacerlo con
los 3 bucles (while, do-while y for) y un contador en cada bucle.
b) A continuación en el mismo programa y con el bucle que prefieras, haz que
muestre los números pares entre 1 y 50. Estos deben quedar bien formateados
en una columna de tamaño 5 caracteres justificados a la derecha mediante
printf.
*/

package PROGRAMACION.evaluacion1.boletin_2;

public class ejercicio1 {
    public static void main(String[] args) {
        
        System.out.print("\n");
        System.out.println();
        
        System.out.println("Usando for:");
        for (int i = 1; i <= 20; i++) {
            System.out.print(i + " ");
        }

        System.out.println("\n\nUsando while:");
        int contadorWhile = 1;
        while (contadorWhile <= 20) {
            System.out.print(contadorWhile + " ");
            contadorWhile++;
        }

        System.out.println("\n\nUsando do-while:");
        int contadorDoWhile = 1;
        do {
            System.out.print(contadorDoWhile + " ");
            contadorDoWhile++;
        } while (contadorDoWhile <= 20);

        System.out.println("\n\nContador de números pares:");
        for (int i = 1; i <= 50; i++) {
            if(i%2 == 0){
                System.out.printf( "%5d\n",i);
            }
        }
    }
}
