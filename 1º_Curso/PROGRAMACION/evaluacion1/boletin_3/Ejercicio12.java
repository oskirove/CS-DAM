/*
 a) Codificar un programa que genere una quiniela aleatoria. Es decir, se deben
 dar 14 resultados aleatorios como 1, X ó 2 indicando delante el número de partido
 y los resultados alineados en una columna (no uses \t, si no ajuste con printf ). Se
 debe realizar al menos una función que devuelva un 1 una X o un 2 (char o String)
 aleatorio.

 b) Realizar la quiniela ponderada, es decir, haz otra función que devuelva 1, X o 2
 pero que la probabilidad de sacar 1 sea del 60%, la de sacar X sea 25% y la de
 sacar un 2 sea un 15%.

 En el main debes dar a elegir quiniela normal o ponderada.

 Pista: Sacar un numero aleatorio entre 1 y 100. Si el resultado es menor o igual
 que 60, se asigna un 1 al resultado, si es entre 61 y 85 (60+25) se le asigna una X
 y si es entre 86 y 100 se le asigna un 2.
*/

package PROGRAMACION.evaluacion1.boletin_3;

import java.util.Scanner;

public class Ejercicio12 {

    /**
     * Imprime una línea de "X" guiones.
     */
    public static void lineas() {
        for (int i = 0; i < 20; i++) {
            String linea = "";
            linea += "-";

            System.out.print(linea);
        }
    }

    /**
     * Devuelve un número aleatorio entre 1, X o 2.
     * 
     * @return "X", "1" o "2".
     */

    public static String quinielaNormal() {
        int randomNum = (int) (Math.random() * 3);
        if (randomNum == 0) {
            return "X";
        } else if (randomNum == 1) {
            return "1";
        } else {
            return "2";
        }
    }

    /**
     * Devuelve un número aleatorio entre 1, X o 2 con diferentes probabilidades.
     * 
     * @return "X", "1" o "2".
     */

    public static String quinielaPonderada() {
        int numAleatorio = (int) (Math.random() * 100);
        if (numAleatorio <= 60) {
            return "1";
        } else if (numAleatorio >= 61 && numAleatorio <= 85) {
            return "X";
        } else {
            return "2";
        }
    }

    /**
     * Imprime una tabla de 14 partidos con sus resultados.
     * 
     * @param ponderada Si es true, se usará la quiniela ponderada.
     */
    public static void tabla(boolean ponderada) {
        for (int i = 1; i <= 14; i++) {
            System.out.printf("| Partido %02d | %2s  | %n", i,
                    ponderada == true ? quinielaPonderada() : quinielaNormal());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("Quiniela");
            System.out.println("--------");
            System.out.println("1. Quiniela normal");
            System.out.println("2. Quiniela ponderada");
            System.out.println("3. Salir");
            System.out.println();
            System.out.print("Introduce una opción: ");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    lineas();
                    System.out.println();
                    tabla(false);
                    lineas();
                    System.out.println();
                    break;
                case 2:
                    lineas();
                    System.out.println();
                    tabla(true);
                    lineas();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 3);
        sc.close();
    }
}
