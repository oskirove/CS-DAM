/*
 a) Realizar un programa que dibuje una ristra de N asteriscos en pantalla (N es
 un número introducido polo usuario).
 Ejemplo:
 Cuantos asteriscos deseas dibujar? 10
 **********
 b) Repetirlo pero dibujando la ristra en diagonal. El usuario escogerá se la
 dibuja de izquierda la derecha o de derecha la izquierda.
*/

package PROGRAMACION.evaluacion1.boletin_2;

import java.util.Scanner;

public class Ejercicio19 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        int opcionDir;

        do {
            System.out.println();
            System.out.println("Bienvenido a la APP de dibujo de asteriscos.");
            System.out.println("--------------------------------------------");
            System.out.println("1.- Dibujar");
            System.out.println("0.- Salir\n");

            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:

                    System.out.print("¿Cuantos asteriscos quieres dibujar?: ");
                    int numeroAsteriscos = sc.nextInt();
                    System.out.println();

                    for (int i = 0; i < numeroAsteriscos; i++) {
                        System.out.print("*");
                    }
                    System.out.println();
                    do {

                        System.out.println("¿Quieres dibujar la ristra de asteriscos en diagonal?");
                        System.out.println("2.- Izquierda a derecha");
                        System.out.println("3.- Derecha a izquierda");
                        System.out.println("4.- Volver atrás\n");
                        System.out.print("Selecciona una opción: ");
                        opcionDir = sc.nextInt();

                        switch (opcionDir) {
                            case 2:
                                String posicion = "";
                                for (int i = 0; i < numeroAsteriscos; i++) {
                                    System.out.print(posicion += " ");
                                    System.out.print("*");
                                    System.out.println();
                                }

                                break;
                            case 3:
                                for (int i = 0; i < numeroAsteriscos; i++) {
                                    for (int j = numeroAsteriscos - i; j > 1; j--) {
                                        System.out.print(" ");
                                    }
                                    System.out.println("*");
                                }

                                break;

                            case 4:
                                System.out.println("Saliendo del programa");
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }

                    } while (opcionDir != 4);
                    break;
                case 2:

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