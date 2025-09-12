/*
 Realizar un programa que saque los siguientes datos por pantalla (usa bucles
 for y haz en un único programa todos los apartados) .
 a) Los números del 1 al 50.
 b) En orden inversa del 50 al 1
 c) Los números pares menores que 20 por orden creciente (2, 4, 6, 8, ... 16,
 18)
 d) Los números impares entre lo 90 y el 130 por orden creciente
 e) Los múltiplos de 5 entre el 70 y el 25 por orden decreciente (70, 65, ...
 30,25).
*/

package PROGRAMACION.evaluacion1.boletin_2;

import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de opciones");
            System.out.println("----------------");
            System.out.println("1.- Imprimir los números del 1 al 50 en orden creciente");
            System.out.println("2.- Imprimir los números del 1 al 50 en orden decreciente");
            System.out.println("3.- Imprimir los números pares menores que 20 por orden creciente");
            System.out.println("4.- Imprimir los números impares entre lo 90 y el 130 por orden creciente");
            System.out.println("5.- Imprimir los múltiplos de 5 entre el 70 y el 25 por orden decreciente");
            System.out.println("0.- Salir del menú\n");

            System.out.print("Introduce una opción: ");
            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    for (int i = 1; i <= 50; i++) {
                        System.out.println(i);
                    }
                    break;
                case 2:
                    for (int i = 50; i > 0; i--) {
                        System.out.println(i);
                    }
                    break;
                case 3:
                    for (int i = 1; i < 20; i++) {
                        if (i % 2 == 0) {
                            System.out.println(i);
                        }
                    }
                    break;
                case 4:
                    for (int i = 90; i < 130; i++) {
                        if (i % 2 != 0) {
                            System.out.println(i);
                        }
                    }
                    break;
                case 5:
                    for (int i = 65; i > 25; i--) {
                        if (i % 5 == 0) {
                            System.out.println(i);
                        }
                    }
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
