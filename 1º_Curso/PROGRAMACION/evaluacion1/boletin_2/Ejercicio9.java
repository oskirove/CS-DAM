/*
Realizar un programa que muestre el máximo de una serie de números enteros
leídos por teclado. Primero se debe pedir la cantidad de números a leer, tras lo
cual se pedirá un número tras otro y cuando se llegue la la cantidad indicada se
mostrará cuál es el máximo de los introducidos.
Ejemplo de salida:
Cuantos números deseas introducir? 3
Introduce número: -5
Introduce número: 9
Introduce número: -2
El número máximo introducido es el 9
Ojo, ten en cuenta que el usuario podría meter todos los números negativos.
*/

package PROGRAMACION.evaluacion1.boletin_2;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuántos números deseas introducir?");
        int numeroCliente = sc.nextInt();

        /*
         Inicializamos una variable llamada máximo con un valor entero 
         que sea la más baja posible para que cualquier número introducido
         sea mayor que este. Esto lo hacemos para que el programa nos permita 
         trabajar con números negativos.
        */
        int maximo = Integer.MIN_VALUE;

        for (int i = 0; i < numeroCliente; i++) {
            System.out.print("Introduce tu número: ");
            int n1 = sc.nextInt();

            /*
             Actualizamos el valor de la variable máximo si
             el número más reciente es mayor, es decir, 
             asignamos el valor de "n1" a "maximo"
            */
            if (n1 > maximo) {
                maximo = n1;
            }
        }

        System.out.println("El número máximo introducido es el " + maximo);
        sc.close();
    }
}