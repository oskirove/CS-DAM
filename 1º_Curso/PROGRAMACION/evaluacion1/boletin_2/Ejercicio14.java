/*
 Contar la cantidad de números negativos introducidos por el usuario. Se termina
 cuando el usuario introduce el cero. Se debe informar también del total de
 números introducidos (no se cuenta el cero).
 Ejemplo de salida:
 Introduce número: -10
 Introduce número: -2
 Introduce número: 3
 Introduce número: 0
 Se introdujeron 2 números negativos de un total de 3. 
*/

package PROGRAMACION.evaluacion1.boletin_2;

import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int salida = 1;
        int contador = 0;
        int contadorTotal = 0;

        while (salida != 0) {
                System.out.print("Introduce un número: ");
                salida = sc.nextInt();
                contadorTotal++;

                if (salida < 0) {
                    contador++;
                }
        }
        if (contador == 1){
            System.out.println("Se introdujo " + contador + " número negativo de un total de " + (contadorTotal - 1) + ".");
        } else {
            System.out.println("Se introdujeron " + contador + " números negativos de un total de " + (contadorTotal - 1) + ".");
        }
        sc.close();
    }
}
