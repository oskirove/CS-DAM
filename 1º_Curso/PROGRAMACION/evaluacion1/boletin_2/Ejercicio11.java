/*
 Escribir un programa que encuentre el primer valor de N para el cuál se cumple
 que la suma
 1+2+3+...+N > 10000. (Nota: la solución es 141). 
*/

package PROGRAMACION.evaluacion1.boletin_2;

public class Ejercicio11 {
    public static void main(String[] args) {
        int contador = 1;
        int suma = 0;

        while (suma <= 10000) {
            suma += contador;
            contador++;
        }

        System.out.println("El primer valor de N para el cual la suma es mayor que 10000 es: " + (contador - 1));
    }
}
