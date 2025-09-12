package PROGRAMACION.evaluacion2.IntroArrays.IntroArrays1;

import java.util.Scanner;

public class EjercicioArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cifra cifra;
        Cifra[] numeros = new Cifra[10];

        for (int i = 0; i < numeros.length; i++) {
            int contador = i + 1;
            cifra = new Cifra();
            System.out.print("Introduce el valor " + contador + ": ");
            cifra.valor = sc.nextInt();
            numeros[i] = cifra;
        }

        System.out.println();

        for (int i = 0; i < numeros.length; i++){
            System.out.printf( "Valor [%s]%n", numeros[i].valor);
        }
        sc.close();
    }
}
