/*
Realizar un programa que pida dos números enteros al usuario y muestre el
mayor de los dos o un mensaje de igualdad en caso de que sean iguales.
También debe indicar si son múltiplos o no.
 */

 package PROGRAMACION.evaluacion1.boletin_2;

import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.println("Introduce un número: ");
        int n1 = sc.nextInt();

        System.out.println("Introduce otro número: ");
        int n2 = sc.nextInt();

        if (n1 < n2 ){
            System.out.println(n1 +" es menor que " + n2);
        } else if ( n1 > n2 ) {
            System.out.println(n1 +" es mayor que " + n2);
        } else  {
            System.out.println(n1 +" es igual a " + n2);
        }

        if (n1 % n2 == 0 || n2 % n1 == 0) {
            System.out.println("Y además son múltiplos");
        } else {
            System.out.println("Y no son múltiplos");
        }
        sc.close();
    }
}
