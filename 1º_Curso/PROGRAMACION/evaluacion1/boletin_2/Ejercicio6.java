/*
Realizar un menú con las opciones (los números se piden en cada opción, es
decir, en cada case):
a) Cuadrado de un número real. Se mostrará con 2 decimales de
aproximación
b) Inverso de un número (1/x). Se mostrará con 4 decimales de
aproximación. No se admite el 0 (vuelve a pedirlo hasta que se meta
distinto de 0).
c) Raíz cuadrada de un número. Debe mostrar el resultado con 3 decimales
de aproximación. No admite números negativos (debe pedir número hasta
que se meta uno positivo o 0). Averigua en internet cómo se haya la raíz
cuadrada en Java.
d) Operación AND a nivel de bit entre dos enteros. Resultado en
hexadecimal.
e) Operación OR a nivel de bit entre dos enteros. Resultado en hexadecimal.
f) Salir. El programa no debe acabar mientras no se pulse esta opción.
*/

package PROGRAMACION.evaluacion1.boletin_2;

import java.util.Scanner;
import java.lang.Math;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {

            System.out.println("Menú de opciones");
            System.out.println("----------------");
            System.out.println("1.- Realizar el cuadrado de un número");
            System.out.println("2.- Realizar el inverso de un número");
            System.out.println("3.- Realizar la raiz cuadrada de un número");
            System.out.println("4.- Realizar una operación AND a nivel de bits");
            System.out.println("5.- Realizar una operación OR a nivel de bits");
            System.out.println("6.- Salir de la aplicación\n\n");
            System.out.println("Teclea una opción (1-6)");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Introduce un número: ");
                    double n1 = sc.nextDouble();
                    double cuadrado = n1 * n1;
                    System.out.printf("El cuadrado de %.2f es %.2f%n", n1, cuadrado);
                    break;
                case 2:
                    double n2; 
                    do {
                        System.out.println("Introduce un número: ");
                        n2 = sc.nextDouble();
                        if (n2 == 0) {
                            System.out.println("El número no puede ser 0");
                        }
                    } while (n2 == 0);
                    double inverso = 1 / n2;
                    System.out.printf("El inverso de %.4f es %.4f%n", n2, inverso);
                    break;
                case 3:
                    System.out.println("Introduce un número: ");
                    double n3 = sc.nextDouble();
                    if (n3 < 0) {
                        System.out.println("El número introducido no es válido");
                        break;
                    }
                    double raiz = Math.sqrt(n3);
                    System.out.printf("La raiz cuadrada de %.2f es %.3f%n", n3, raiz);
                    break;
                case 4:
                    System.out.println("Introduce un número: ");
                    int numero4_1 = sc.nextInt();
                    System.out.println("Introduce otro número: ");
                    int numero4_2 = sc.nextInt();
                    int operacionAnd = numero4_1 & numero4_2;
                    System.out.printf("El resultado de la operación AND entre el número %d y el número %d es: %X%n",
                            numero4_1, numero4_2, operacionAnd);
                    break;
                case 5:
                    System.out.println("Introduce un número: ");
                    int numero5_1 = sc.nextInt();
                    System.out.println("Introduce otro número: ");
                    int numero5_2 = sc.nextInt();
                    int operacionOr = numero5_1 | numero5_2;
                    System.out.printf("El resultado de la operación AND entre el número %d y el número %d es: %X%n",numero5_1, numero5_2, operacionOr);
                    break;
                case 6:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 6);
        sc.close();
    }
}
