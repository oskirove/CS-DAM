/*
 Modifica el ejercicio anterior de los números primos (solo el main) de forma
 que hagas un menú clásico con estas opciones:
 
 1. Mostrar primos menores que uno dado: Esto es lo que ya estaba del
 ejercicio previo.

 2. Primos en archivo: Pide el nombre de un archivo que debe contener
 números, cada uno en una línea. Lee dicho archivo y muestra dichos números
 en pantalla diciendo si son o no primos.

 3. Archivo con primos: Similar a 1, se le pide un número mayor que 2 al
 usuario y guarda en un archivo todos los primos desde 2 hasta el que meta el
 usuario. Estarán todos en la misma línea separados por punto y coma (;).

 4 Salir: El programa solo finaliza si se selecciona esta opción.
*/

package PROGRAMACION.evaluacion1.boletin_3;

import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio9 {

    /**
     * Comprueba si un nº es primo
     * 
     * @param numero Nº a comprobar
     * @return true si el número es primo y false si no lo es
     */
    public static boolean numPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        ;

        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        ;
        return true;
    };

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú de opciones");
            System.out.println("----------------");
            System.out.println("1. Mostrar primos menores que uno dado");
            System.out.println("2. Primos en archivo");
            System.out.println("3. Archivo con primos");
            System.out.println("4. Salir del programa");
            System.out.println();
            System.out.print("Introduce una opción: ");

            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Introduce un número mayor que 2 para salir: ");
                    int num = sc.nextInt();

                    for (int i = 2; i < num; i++) {
                        if (numPrimo(i)) {
                            System.out.println(i);
                        }

                    }

                    break;
                case 2:
                    System.out.println("Introduce el nombre del archivo: ");
                    String archivo = sc.next();
                    Scanner lector = new Scanner(new FileReader(archivo));

                    while (lector.hasNextLine()) {
                        String linea = lector.nextLine();
                        /*
                         * Verifica si el número convertido desde la cadena 'linea' es primo y,
                         * si lo es, imprime la cadena 'linea'
                         * 
                         * Nota: (Integer.parseInt(linea) se utiliza para convertir una cadena de texto
                         * (String)
                         * que representa un número entero en un valor de tipo int.
                         */
                        if (numPrimo(Integer.parseInt(linea))) {
                            System.out.println(linea);
                        }
                    }

                    lector.close();
                    break;

                case 3:
                    PrintWriter f = new PrintWriter(new FileWriter("datos.txt"));

                    System.out.println("Introduce un número mayor que 2: ");
                    int numero = sc.nextInt();

                    for (int i = 2; i <= numero; i++)
                        if (numPrimo(i) == true) {
                            f.print(i + "; ");
                        }

                    f.close();
                    break;

                case 4:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 4);
        sc.close();
    }
}