/*
 Realizar un programa que calcule el factorial de un número (usar tipo long o
 real) introducido por el usuario (haz sólo un programa que realice 3 veces el
 cálculo). No se permite el uso de sentencias if :
 a) Con un bucle for.
 b) Con un bucle do-while
 c) Con un bucle while
*/

package PROGRAMACION.evaluacion1.boletin_2;

import java.util.Scanner;

public class Ejercicio18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n1 = sc.nextInt();

        int acumuladorFor = 1;
        int acumuladorWhile = 1;
        int acumuladorDoWhile = 1;
        int contadorWhile = 0;
        int contadorDoWhile = 0;


        for (int i = 1; i <= n1; i++) {
            acumuladorFor*=i;
        }

        while (contadorWhile < n1) {
            contadorWhile++;
            acumuladorWhile*=contadorWhile;
        }

        do {
            contadorDoWhile++;
            acumuladorDoWhile*=contadorDoWhile;
        } while (contadorDoWhile < n1);

        System.out.println("Este es el resultado del bucle FOR: " + acumuladorFor);
        System.out.println("Este es el resultado del bucle WHILE: " + acumuladorWhile);
        System.out.println("Este es el resultado del bucle DO WHILE: " + acumuladorDoWhile);
        sc.close();
    }
}
