/*
 Hacer con bucles for (en un único programa todos los apartados):
 a) Programa que dé el resultado de la suma de números pares entre 0 y N (N lo
 decide el usuario).
 b) Programa que dé el resultado de la suma de números impares entre 0 y N (N
 lo decide el usuario).
 c Programa que dé el resultado de la suma de números pares por una parte e
 impares por otro entre 0 y N (N lo decide el usuario). Debe realizarse con
 un único bucle.
*/

package PROGRAMACION.evaluacion1.boletin_2;

import java.util.Scanner;

public class Ejercicio13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú de opciones");
            System.out.println("----------------");
            System.out.println("1.- Suma los números pares entre 0 y un número que elijas");
            System.out.println("2.- Suma los números impares entre 0 y un número que elijas");
            System.out.println("3.- Hacer ambas");
            System.out.println("0.- Salir del menú\n");

            System.out.print("Introduce una opción: ");
            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce un valor: ");
                    int n1 = sc.nextInt();
                    int acumuladorPares = 0;

                    for (int i = 0; i <= n1; i++) {
                        if (i % 2 == 0) {
                            acumuladorPares += i;
                        }
                    }
                    System.out.println("La suma de los números pares hasta " + n1 + " es: " + acumuladorPares);
                    break;
                case 2:
                    System.out.print("Introduce un valor: ");
                    int n2 = sc.nextInt();
                    int acumuladorImpares = 0;

                    for (int i = 0; i <= n2; i++) {
                        if (i % 2 != 0) {
                            acumuladorImpares += i;
                        }
                    }
                    System.out.println("La suma de los números pares hasta " + n2 + " es: " + acumuladorImpares);
                    break;
                case 3:
                    System.out.print("Introduce un valor: ");
                    int n3 = sc.nextInt();
                    int acumuladorPar = 0;
                    int acumuladorImpar = 0;

                    for (int i = 0; i <= n3; i++) {
                        if (i % 2 != 0) {
                            acumuladorImpar += i;
                        }else{
                            acumuladorPar += i;
                        }
                    }
                    System.out.println("La suma de los números pares hasta " + n3 + " es: " + acumuladorPar
                            + " y la suma de los números impares hasta " + n3 + " es: " + acumuladorImpar);
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
        sc.close();
    }
}
