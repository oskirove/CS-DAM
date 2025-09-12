/*
 Amplia el programa anterior (directamente el main) para que guarde en un
 archivo los siguientes datos: el nombre en una línea, el número en la siguiente y si
 es par/impar y positivo/negativo.
 El archivo queda algo así:
 Minerva McGonagall
 -5
 El n.º es impar in negativo.
*/

package PROGRAMACION.evaluacion1.boletin_3;

import java.io.PrintWriter;

public class Ejercicio2 {

    /**
     * Deja en pantalla n líneas en blanco
     * 
     * @param n
     */

    public static void funcionLineas(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
        }
    }

    /**
     * Devuelve true si el parámetro es número par y false si no lo es
     * 
     * @param numPar
     * @return
     */

    public static boolean par(int numPar) {
        if (numPar % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve 'P' si el número es positivo o cero y 'N' si es negativo
     * 
     * @param num
     * @return
     */

    public static char FuncionPoN(int num) {
        char resultado = (num < 0) ? 'N' : 'P';
        return resultado;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        funcionLineas(20);

        System.out.print("Introduce un número: ");
        int num = sc.nextInt();
        System.out.println();

        /*
         * Un try-catch intenta ejecutar código en el bloque try.
         * Si ocurre un error, el bloque catch lo captura y maneja,
         * evitando que el programa se cierre inesperadamente.
         * Muestra un mensaje de error si no se puede crear el archivo.
         */

        try {
            PrintWriter f = new PrintWriter("Datos.txt");
            f.println("Tu nombre es: " + nombre);
            f.println("El número seleccionado ha sido: " + num);
            f.println("El n.º es " + (par(num) ? "par" : "impar") + " y "
                    + (FuncionPoN(num) == 'P' ? "positivo" : "negativo") + ".");

            System.out.println("Hola " + nombre + ", tu número es " + (FuncionPoN(num) == 'P' ? "positivo" : "negativo")
                    + " y además es un número " + (par(num) ? "par." : "impar."));

            System.out.println("Esta información se ha guardado en el documento Datos.txt.");
            f.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Error: No se pudo crear el archivo.");
        }
        sc.close();
    }
}
