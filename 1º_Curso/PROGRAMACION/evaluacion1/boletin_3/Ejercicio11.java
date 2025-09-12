/*
 a) Realizar una función que devuelva el factorial de un número según se definió en el 
 boletín anterior (recuerda que 0!=1). Hazlo con parámetro int pero que devuelva double o long.

 b) El cálculo del coseno de un ángulo se puede aproximar por el siguiente cálculo: 

    aproximación de Taylor:
    cos(x) = 1 - x^2/2! + x^4/4! - x^6/6! + x^8/8! - x^10/10! + ...

 Realizar un método que realice y devuelva dicho cálculo (hazlo al menos hasta el
 termino de potencia 4. Si quieres mete más). Debes usar la función factorial hecha
 en el apartado anterior y la de potencia hecha en un ejercicio previo.

 c) Realizar un programa que muestre por pantalla los cosenos de los ángulos de 0.1
 , 0.2, y hasta 1 radian. Además en cada línea mostrará el resultado del coseno
 según tu función y el error absoluto obtenido de restarlo de la función Math.cos().
 Usa 5 decimales de aproximación para todo y que los valores ocupen 8 posiciones.

 Opcional: Realiza la función factorial aplicando recursividad (ver apéndice de
 apuntes, evita buscar en internet).
 definió en el boletín anterior (recuerda que 0!=1). Hazlo con parámetro int pero
*/

package PROGRAMACION.evaluacion1.boletin_3;

import java.lang.Math;

public class Ejercicio11 {

    /**
     * Realiza el factorial de un número de forma recursiva.
     * 
     * @param num Número al que se le va a realizar el factorial.
     * @return El factorial del número.
     */

    public static int factorialRec(int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorialRec(num - 1);
    }

    /**
     * Realiza el factorial de un número.
     * 
     * @param num Número al que se le va a realizar el factorial.
     * @return El factorial del número.
     */

    public static double factorial(double num) {
        double acumulador = 1;

        for (double i = 1; i <= num; i++) {
            acumulador *= i;
        }
        ;

        return acumulador;
    };

    /**
     * Realiza el cálculo del coseno de un número.
     * 
     * @param x Número al que se le va a realizar el cálculo del coseno.
     * @return El coseno del número.
     */

    public static double coseno(double x) {

        double valorCoseno = 1;

        valorCoseno -= Ejercicio6.potencia(x, 2) / factorial(2);
        valorCoseno += Ejercicio6.potencia(x, 4) / factorial(4);
        valorCoseno -= Ejercicio6.potencia(x, 6) / factorial(6);
        valorCoseno += Ejercicio6.potencia(x, 8) / factorial(8);
        valorCoseno -= Ejercicio6.potencia(x, 10) / factorial(10);
        valorCoseno += Ejercicio6.potencia(x, 12) / factorial(12);
        valorCoseno += Ejercicio6.potencia(x, 14) / factorial(14);

        return valorCoseno;
    }

    public static void bucleCoseno() {

        for (double i = 0.1; i <= 1; i += 0.1) {
            System.out.printf("El coseno de %.1f es: %8.5f", i, coseno(i));
            System.out.println();
        }
        ;
    };

    public static void bucleCosenoError() {
        System.out.printf("El error absoluto es: %8.5f", coseno(0.2) - Math.cos(0.2));
        System.out.println();
    }

    public static void main(String[] args) {

        bucleCoseno();
        System.out.println();
        bucleCosenoError();
        System.out.println();
        System.out.println("El factorial con la función con un bucle es: " + factorial(6));
        System.out.println("El factorial con la función recursiva es: " + factorialRec(6));
    }
}
