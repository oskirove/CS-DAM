/*
 Realizar un conversor de euros a libras y de libras a euros. No debe admitir
 valores negativos: si el usuario mete negativo, informa del error y lo vuelve a
 pedir hasta que meta positivo. Debe ejecutarse de forma continua hasta que el
 usuario lo desee (plantea un menú con dos opciones de conversión y salir).
 Debe presentar los datos con 2 decimales.
*/

package PROGRAMACION.evaluacion1.boletin_2;

import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Conversor de monedas");
            System.out.println("----------------");
            System.out.println("1.- Convertir de Euros a Libras");
            System.out.println("2.- Convertir de Libras a Euros");
            System.out.println("0.- Salir del conversor\n");

            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:

                    double cantidadEuros;
                    do {
                        System.out.print("Introduce un valor: ");
                        cantidadEuros = sc.nextDouble();
                        if (cantidadEuros < 0) {
                            System.out.println("ADVERTENCIA! El valor no puede ser negativo. Inténtalo de nuevo.");
                            System.out.println();
                        }
                    } while (cantidadEuros < 0);

                    double resLibras = cantidadEuros * 0.86;

                    System.out.printf("%.2f€ son %.2f£\n", cantidadEuros, resLibras);
                    System.out.println();
                    break;
                case 2:

                    double cantidadLibras;
                    do {
                        System.out.print("Introduce un valor: ");
                        cantidadLibras = sc.nextInt();
                        if (cantidadLibras < 0) {
                            System.out.println("ADVERTENCIA! El valor no puede ser negativo. Inténtalo de nuevo.");
                            System.out.println();
                        }
                    } while (cantidadLibras < 0);

                    double resEuros = cantidadLibras * 1.16;

                    System.out.printf("%.2f€ son %.2f£\n", cantidadLibras, resEuros);
                    System.out.println();

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
