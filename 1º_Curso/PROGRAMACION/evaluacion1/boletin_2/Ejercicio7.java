/*
a) Realizar un programa que acepte 5 números del usuario y calcule y muestre
su media (la media es la suma de los números dividido entre 5). Al final debe
permitir ejecutar de nuevo el programa o salir del mismo.
Nota: Puedes hacer directamente el apartado (b) y saltarte el (a).
b) Mejorar el apartado anterior (o realiza otro programa) de forma que admita
una cantidad indefinida de números. Es decir, el usuario introduce números y
acaba cuando pulse el 0. En ese momento calcula la media (el 0 no se incluirá
en el cálculo de la media).
*/

package PROGRAMACION.evaluacion1.boletin_2;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        int contador = -1;
        int acumulador = 1;

        do {
            System.out.println("Menú de opciones");
            System.out.println("----------------");
            System.out.println("1.- Realizar la media de varios números");
            System.out.println("2.- Salir del menú\n");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    int n1 = 1;
                    while (n1 == 0) {
                        System.out.print("Introduce un número o introduce 0 para salir al menú: ");

                        n1 = sc.nextInt();
                        contador++;

                        /*
                         * Creamos una variable a la que se le sumará
                         * el valor de n1 en cada vuelta del bucle
                         */
                        acumulador += n1;

                    }
                    System.out.println("La media es: " + (acumulador - 1) / contador);
                case 2:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 2);
        sc.close();
    }
}
