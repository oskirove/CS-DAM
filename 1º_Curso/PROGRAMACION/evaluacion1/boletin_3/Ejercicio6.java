/*
 a) Realizar una función que halle y devuelva la potencia de un número ( No se
 permite usar funciones de Math ). La base puede ser real y el exponente entero
 puede ser negativo (recuerda que a - b = (1/a)b ).
 Parámetros del método: la base y el exponente. Valor devuelto: la potencia

 b) Realiza un nuevo método (en la misma clase) que muestre en pantalla las n
 primeras potencias de un número a (n y a serán parámetros del método).
 Por ejemplo, si los parámetros son a=2 y n=4 mostrará: 1, 2, 4, 8.
 Para hacerlo deberás llamar al creado en el apartado anterior para calcular las
 potencias, no las puedes calcular de nuevo en este método.

 c) Escribe un método que sume la progresión geométrica ( x puede ser real) y
 devuelva el resultado.
 1+x+x2 + x3 + x4 +... xn
 Se debe utilizar la función potencia (sin modificarla, sólo llamándola) programada
 anteriormente.
 Por ejemplo si x=2 y n=4 mostrará 15 por ser el resultado de 1+2+4+8.
 Parámetros del método: x y n. Valor devuelto: resultado de la progresión
*/

package PROGRAMACION.evaluacion1.boletin_3;

import java.util.Scanner;

public class Ejercicio6 {

    /**
     * Calcula la potencia de un número.
     * @param baseFuncion es la base de la potencia.
     * @param exponente es el exponente de la potencia.
     * @return la potencia de la base elevada al exponente.
     */

    public static double potencia(double baseFuncion, int exponente) {

        double resultado = 1;
        
        if (exponente < 0) {
            baseFuncion = 1 / baseFuncion;
            exponente = -exponente;
        }

        for (int i = 0; i < exponente; i++) {
            resultado *= baseFuncion;
        }

        return resultado;
    }

    /**
     * Muestra las n primeras potencias de un número.
     * @param base es la base de la potencia.
     * @param exponente es el número de potencias a mostrar.
     * @return la última potencia calculada.
     */

    public static double contPotencia(double base, int exponente) {
        double contador = 0;
        for (int i = 0; i < exponente; i++){
            contador = potencia(base, i);
            System.out.printf("%.2f,%n", contador);
        };

        return contador;
    }

    /**
     * Suma las n primeras potencias de un número.
     * @param base es la base de la potencia.
     * @param exponente exp max
     * @return la suma de las potencias.
     */

    public static double sumaPotencia(double base, int exponente) {

        double suma = 0;
        for (int i = 0; i <= exponente; i++){
            suma += potencia(base, i);
        };

        return suma;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la base: ");
        double base = sc.nextDouble();

        System.out.print("Introduce el exponente: ");
        int exponente = sc.nextInt();
        System.out.println();

        System.out.printf("El resultado de la potencia es: %.6f%n",potencia(base, exponente));
        System.out.println();
        contPotencia(base, exponente);
        System.out.println();
        System.out.printf("La suma de las primeras potencias es: %.2f,%n", sumaPotencia(base, exponente));
        System.out.println();
        sc.close();
    }
}
