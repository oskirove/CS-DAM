/*
Haz un programa que pida un nº entero al usuario y luego un número real.
El entero debe mostrarlo primero en decimal; luego en octal ocupando 5
caracteres y rellenando los vacíos a la izquierda con ceros (busca como
hacerlo); y en hexadecimal poniendo los dígitos “letra” en mayúscula.
El real lo mostrará con 3 decimales y ocupando al menos 7 caracteres.
*/

package PROGRAMACION.evaluacion1.boletin_2;

import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.print("Introduce un número entero: ");
        int n1 = sc.nextInt();
 
        System.out.print("Introduce un número real: ");
        float n2 = sc.nextFloat();

        System.out.printf("El número entero es: %d%nEn octal es: %5o%nEn hexadecimal es: %X\nEl número real es: %7.3f%n", n1, n1, n1, n2);
        sc.close();
    }
}