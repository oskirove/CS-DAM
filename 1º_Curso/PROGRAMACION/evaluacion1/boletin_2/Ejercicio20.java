/*
 a) Visualizar en pantalla una figura similar a la siguiente:
 *
 **
 ***
 ****
 *****
 siendo variable (decidido por el usuario) el número de líneas a mostrar.
 b) A continuación, y con la misma cantidad de líneas que en el caso anterior, dibuja
 una pirámide como esta:
     *
    ***
   *****
  *******
 *********
*/

package PROGRAMACION.evaluacion1.boletin_2;

public class Ejercicio20 {
    public static void main(String[] args) {

        String nada = "";

        for (int i = 0; i < 5; i++) {
            System.out.print(nada += "*");
            System.out.println();
        }

        System.out.println();

        int altura = 8;

        /*
         Creamos un bucle externo que nos
         defina la altura de la piramide con filas 
        */
        for (int i = 0; i < altura; i++) {

            /*
             Dentro de este creamos otro bucle que nos genere los espacios
             para centrar los asteriscos.

             Estos espacios iran decrementandose a medida que la variable "i"
             del bucle externo aumenta.
            */
            for (int j = altura - i; j > 1; j--) {
                System.out.print(" ");
            }
            /*
             Ahora creamos otro bucle para los asteriscos de la derecha 
             donde K, si es menor o IGUAL a la variable "i" del primer bucle, 
             se detendrá y dejará de imprimir los asteriscos en la misma linea
            */
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }

            /*
             Este bucle añade los asteriscos a la 
             izquierda dela misma forma que el anterior
            */
            for (int l = 0; l < i; l++) {
                System.out.print("*");
            }
            /*
             Con esto agregamos un salto de linea despues de que actuen los 
             bucles anteriores y así le proporcionamos la estructura de piramide 
            */
            System.out.println();
        }

        System.out.println();
    }

}
