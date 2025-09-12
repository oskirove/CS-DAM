/*
 a) Escribir una función que se le pase un número y que devuelva true o false
 dependiendo de si dicho número es o no es primo.

 b) Para probarla haz un programa principal que pida un n.º mayor que 2 al usuario
 y muestra los números primos menores que dicho número.

 Nota: Un número es primo si y sólo si es divisible únicamente por 1 y por él mismo.
 Por tanto para saber si un número es primo se debe dividir por todos los números
 menores que él y mayores que 1, y si alguna de esas divisiones exacta entonces el
 número NO es primo. Existen métodos de optimizar lo anterior, piensa a ver si se te
 ocurre alguno. El 1 actualmente no se considera primo.
*/

package PROGRAMACION.evaluacion1.boletin_3;

import java.util.Scanner;

public class Ejercicio8 {

    /**
     * Comprueba si un número es primo.
     * @param numero es el número a comprobar.
     * @return true si el número es primo, false si no lo es.
     */

    public static boolean numPrimo(int numero){
       if (numero <= 1){
        return false;
       };

       for (int i = 2; i < numero; i++){
        if (numero % i == 0){
            return false;
        }
       };
       return true;
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número mayor que 2: ");
        int num = sc.nextInt();

        for (int i = 2; i < num; i++){
            if(numPrimo(i)){
                System.out.println(i);
            }
        };
        sc.close();
    }

}
