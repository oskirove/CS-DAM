/*
Programa un conversor de temperaturas:
Al usuario se le pide los grados Celsius y se le da dos opciones: si los quiere
convertir a Farenheit (1) o a Kelvin (2). Las opciones serán 1 y 2 para pedir
tipo de conversión y 3 salir.
Usa como plantilla el código que hay en el apartado de la estructura do-while
pero solo con las 3 opciones aquí indicadas .
El programa se repetirá hasta que se elija 3.
Finalmente muestra el resultado de la conversión con 2 decimales. Usa doubles
para las conversiones.
Las funciones de conversión son:
K=C+273.15
F=1.8*C+32
*/

package PROGRAMACION.evaluacion1.boletin_2;

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {

            System.out.println("Menú de opciones");
            System.out.println("----------------");
            System.out.println("1.- Conversión a Kelvin: ");
            System.out.println("2.- conversión a Farenheit: ");
            System.out.println("3.- Salir del menú\n\n");
            System.out.println("Teclea una opción (1-3)");
            numero = sc.nextInt();
            switch (numero) {
                case 1: 
                    System.out.println("Introduce los grados centígrados: ");
                    double gradosCentigradosKelvin = sc.nextDouble();
                    double ConversionKelvin = gradosCentigradosKelvin + 273.15;

                    System.out.printf("Los grados Kelvin son: %.2f\n", ConversionKelvin);
                    break;
                case 2: 
                    System.out.println("Introduce los grados centígrados: ");
                    double gradosCentigradosFarenheit = sc.nextDouble();
                    double conversionFarenheit = 1.8 * gradosCentigradosFarenheit + 32;

                    System.out.printf("Los grados Farenheit son: %.2f\n", conversionFarenheit);

                    break;
                case 3: 
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (numero != 3);
        sc.close();
    }
}
