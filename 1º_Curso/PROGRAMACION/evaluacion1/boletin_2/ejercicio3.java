/*
Haz un programa que pida un nº al usuario.
Si es positivo realiza mediante un bucle, un contador y un acumulador la suma
de números desde el 1 hasta el que metió el usuario. Finalmente muestra dicha
suma final.
Si el número es negativo o 0 no hace nada.
T*/

package PROGRAMACION.evaluacion1.boletin_2;

import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            System.out.print("Introduce un número: ");
        int n1 = sc.nextInt();
        if (n1 < 0) {
            System.out.println("El número introducido no es válido");
        } else {
            int acumulador = 0;
            for (int i = 1; i <= n1; i = i + 1) {
                acumulador += i;
                System.out.println(i);
            }
            System.out.println("La suma total de los números anteriores es: " + acumulador);
        }
        sc.close();
    }
}
