/*
 En el mismo archivo haz las siguientes funciones:
 a) Codifica un método que deje en pantalla n líneas en blanco ( es un parámetro).
 No devuelve nada. 

 b) Escribe una función denominada par con un único parámetro entero. Devuelve
 true si el parámetro es número par y false si no lo es. No muestra nada.
 
 c) Escribir una función que tenga un argumento (otra forma de llamar a un
 parámetro) de tipo entero y que devuelva la letra ‘P’ (devuelve char) si el número
 es positivo o cero y la letra ‘ N’ si es negativo. Intenta hacerlo con el operador
 ternario (ver Apéndice I del Tema 2); si no te sale hazlo con if.

 d) En el programa principal primero pides el nombre del usuario. A continuación
 dejas deja 10 líneas en blanco mediante la 1ª función. Luego pides un número
 entero al usuario e indicas si es par y positivo o negativo.
*/

package PROGRAMACION.evaluacion1.boletin_3;

import java.util.Scanner;

public class Ejercicio1 {

    /**
     * Deja en pantalla n líneas en blanco
     * @param n Cantidad de lineas
     */

    public static void funcionLineas(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
        }
    }

    /**
     *  Comprueba si un nº es par
     * @param numPar Nº a comprobar
     * @return true si el parámetro es número par y false si no lo es
     */

    public static boolean par(int numPar) {
        if (numPar % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Comprieba si un nº es pos o neg 
     * @param num Nº a comprobar
     * @return 'P' si el número es positivo o cero y 'N' si es negativo
     */

    public static char FuncionPoN(int num) {
        char resultado = (num < 0) ? 'N' : 'P';
        return resultado;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();
        
        funcionLineas(20);

        System.out.print("Introduce un número: ");
        int num = sc.nextInt();
        System.out.println();

        System.out.println("Hola " + nombre + ", tu número es " + (FuncionPoN(num) == 'P' ? "positivo" : "negativo") + " y además es un número " + ((par(num) == true) ? "par." : "impar."));
        sc.close();
    }
}
