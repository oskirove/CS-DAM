/*
 a) Escribir un programa que muestre por pantalla los múltiplos de 5 entre 1 y
 100 y la suma de los mismos (Si lo ves claro, p uedes hacer directamente el
 apartado (b) y saltarte el (a)).
 b) A continuación debe pedir un número entre 1 y 50 y mostrará los múltiplos
 entre 1 y 100 de dicho número y la suma de los mismos. Permitirá la repetición
 del programa (solo del apartado b).
 Ejemplo:
 Introduzca nº entre 1 y 50: 25
 25, 50, 75, 100
 La suma de los múltiplos es: 250
 Desea probar otro número (S/N)? N 
*/

package PROGRAMACION.evaluacion1.boletin_2;

import java.util.Scanner;

public class ejercicio17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int acumulador ;
        char continuar;
        int num;
        
        do{
            acumulador = 0;
            do {
                System.out.print("Introduce un número entre 1 y 50: ");
                num = sc.nextInt();
                if (num < 1 || num > 50) {
                    System.out.println("ERROR: El número debe estar entre 1 y 50.");
                }
            } while (num < 1 || num > 50);

            for (int i = 1; i <= 100; i++) {
                if (i % num == 0) {
                    acumulador += i;
                    System.out.print(i + ", ");
                }
            }
            System.out.println("La suma de los múltiplos es: " + acumulador);

            System.out.print("Deseas continuar S/N: ");
            continuar = sc.next().charAt(0);

            if (continuar == 's' || continuar == 'S') {
            }

        } while (continuar != 'N' && continuar != 'n');
        sc.close();
    }
}
