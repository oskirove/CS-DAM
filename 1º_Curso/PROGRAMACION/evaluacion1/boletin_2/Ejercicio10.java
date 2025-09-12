/*
 Realizar un programa que pida dos números al usuario en sendas variables y
 luego intercambie el valor de dichas variables. Finalmente mostrará en pantalla
 ambas variables.
 Nota: A este algoritmo se le denomina swapping o intercambio de variables y
 tiene diversas aplicaciones.
*/

package PROGRAMACION.evaluacion1.boletin_2;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
         Inicializamos dos variables temporales para almacenar los valores de n1 y n2
        */
        int temp1;
        int temp2;

        System.out.print("Introduce el primer número: ");
        int n1 = sc.nextInt();
        System.out.print("Introduce el segundo número: ");
        int n2 = sc.nextInt();
        /*
         Añadimos el valor de n1 a temp1 y el valor de n2 a temp2 para 
         finalmente reasignar el valor de temp1 a n2 y el valor de temp2 a n1
        */
        temp1 = n1;
        //n1=n2;
        //n2=temp1;

        temp2 = n2;
        n2 = temp1;
        n1 = temp2;

        System.out.println("El primer número se ha cambiado por " + n1 + " y el segundo número se ha cambiado por " + n2);
        sc.close();
    }
}
