/*
 Realiza un programa que halle la superficie de un cilindro sabiendo que:
 Superficie=2*π*radio*altura

 Debe constar de 3 métodos:
 • pedirDato: pide un dato real al usuario comprobando que sea un valor
 positivo. Al final devuelve dicho dato.

 • superficieCilindro: Se le pasa como parámetros el radio y la altura,
 hace el cálculo de la superficie y lo devuelve (sin nada de interfaz de
 usuario).

 • mostrarDato: Función que tiene un real como parámetro y un String.
 Muestra en la misma línea el String y a continuación el real con 3
 decimales. No devuelve nada.

 Por tanto en el programa principal (main) solo debe llamarse a los tres métodos (y
 declarar variables auxiliares para recoger los datos). Dos veces al primero para
 pedir primero radio y después la altura, luego se llama al segundo para hacer el
 cálculo, y finalmente se llama al tercero para mostrar el resultado. Si lo necesitas
 usa variables intermedias para quedar con resultados de las funciones.
*/

package PROGRAMACION.evaluacion1.boletin_3;

import java.util.Scanner;

public class Ejercicio3 {

    /**
     * Pide un dato real al usuario comprobando que sea un valor positivo
     * 
     * @return dato introducido por el usuario
     */

    public static double pedirDato() {
        Scanner sc = new Scanner(System.in);

        double dato;

        do {
            System.out.print("Introduce un número positivo: ");
            dato = sc.nextDouble();
            if (dato < 0) {
                System.out.println("ERROR: El número debe ser positivo.");
            }
            ;
        } while (dato < 0);
        sc.close();
        return dato;
    }

    /**
     * Calcula la superficie de un cilindro
     * 
     * @param radio  es el radio del cilindoro
     * @param altura es l altura del cilindro
     * @return resultado del cálculo de la superficie
     */

    public static double superficieCilindro(double radio, double altura) {

        double superficie = 2 * 3.14159265 * radio * altura;

        return superficie;
    }

    /**
     * Muestra en la misma línea el String y a continuación el real con 3 decimales.
     * 
     * @param resultado Cálculo de la superficie
     * @param mensaje   Mensaje que se visualizará por pantalla.
     */

    public static void mostrarDato(String mensaje, double resultado) {
        System.out.printf("%s %.2f%n", mensaje, resultado);
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println();
        System.out.println("Calculadora de superficie de cilindros");
        System.out.println("=======================================");
        System.out.println("Introduce los datos del cilindro");
        double primerValor = pedirDato();
        double segundoValor = pedirDato();

        double resultado = superficieCilindro(primerValor, segundoValor);

        mostrarDato("La superficie es:", resultado);
        sc.close();
    }
}
