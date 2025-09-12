package PROGRAMACION.evaluacion1.Prueba_Examen_1Ev;

import java.lang.Math;
import java.util.Scanner;

public class Examen_1_Ev_prueba {

    public static void bucles() {
        int resultado = 1;

        for (int contImpares = 39; contImpares >= 5; contImpares -= 2) {
            System.out.printf("%02d ", contImpares);
        }
        ;

        for (int contPares = 2; contPares <= 10; contPares += 2) {
            resultado *= contPares;
        }
        ;

        System.out.println();
        System.out.println("El total de la multiplicación de todos los números pares hasta 10 es: " + resultado);
        System.out.println();
    };

    /**
     * Calcula la potencia de un número.
     * 
     * @param num1 es la base de la potencia.
     * @param num2 es el exponente de la potencia.
     * @return la potencia de la base elevada al exponente.
     */

    public static int calculos(int num1, int num2) {

        int resultado = 1;

        if (num2 > 0) {
            for (int i = 0; i < num2; i++) {
                resultado *= num1;
            }
        } else if (num2 < 0) {
            resultado = num1 % num2;
        } else if (num2 == 0) {
            resultado = (int) (Math.random() * num1) + 1;

            if (num1 < 10) {
                resultado = (int) (Math.random() * 10) + 10;
            }
        }
        ;
        return resultado;
    }

    /**
     * Pide números reales al usuario y incluye la media o la suma de los mismos.
     * 
     * @param veces   es la cantidad de números a pedir.
     * @param trigger es un booleano que si es true devuelve la suma y si es false devuelve la media.
     * @return la media o la suma de los números pedidos.
     */

    public static double mediasOSumas(int veces, boolean trigger) {
        Scanner sc = new Scanner(System.in);

        double resultado = 0;
        double acumulador = 0;
        int contador = 0;

        do {
            System.out.print("Introduce un número: ");
            double numero = sc.nextInt();
            contador += 1;

            if (trigger == true) {
                resultado = acumulador += numero;
            } else {
                resultado = (acumulador += numero) / veces;
            }
            ;

        } while (contador != veces);
        sc.close();
        return resultado;
    }

    public static void piramide() {

        for (int i = 10; i > 0; i--) {
            System.out.printf("%n");

            for (int n = i; n > 0; n--) {
                System.out.printf("%d ", n);
            }
        }

        System.out.printf("%n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println();

        int opcion;
        do {
            System.out.println("1.- Llama a la función bucles");
            System.out
                    .println("2.- Pide dos números enteros y se los pasa a la función calculos. Muestra el resultado.");
            System.out.println(
                    "3.- Llama a la función mediasOSumas calculando la media. Muestra el resultado con 3 decimales.");
            System.out.println("4.- Llama a la función piramide");
            System.out.println("5.- Salir del programa");

            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();

            System.out.println();

            switch (opcion) {
                case 1:
                    bucles();
                    break;
                case 2:
                    System.out.print("Introduce un número: ");
                    int num1 = sc.nextInt();

                    System.out.print("Introduce un número: ");
                    int num2 = sc.nextInt();

                    System.out.println(calculos(num1, num2));

                    break;
                case 3:
                    System.out.printf("%.3f%n", mediasOSumas(4, false));
                    System.out.println();
                    break;
                case 4:

                    piramide();
                    break;
                case 5:

                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 5);
        sc.close();
    }
}
