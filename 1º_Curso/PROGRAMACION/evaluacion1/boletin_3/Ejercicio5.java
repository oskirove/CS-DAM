/*
Haz un programa que realice las siguientes tareas:
Pide un año al usuario y guarda en un archivo dicho año en la primera línea
indicando si es o no bisiesto y a continuación todos los bisiestos desde ese año
hasta el año actual (cada uno en una línea).
Un ejemplo de como puede quedar el archivo:
2015 No es bisiesto.
2016
2020
2024
A continuación lee el archivo y muestra en pantalla todos los años menos el
primero. Debe estar separados por comas en la misma linea y ocupando 6
caracteres.
Si este programa lo tienes en la misma carpeta que el de bisiesto no es necesario
que copies la función, puedes acceder a ella poniendo NombreClase.nombreFuncion.
Por ejemplo:
Bol3Ejer4.bisiesto(2024);
*/

package PROGRAMACION.evaluacion1.boletin_3;

import java.io.PrintWriter;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Introduce un año: ");
        int año = sc.nextInt();

        try {
            PrintWriter f = new PrintWriter("Años_Bisiestos.txt");
            f.println((Ejercicio4.añoBisiesto(año) == true) ? año + " es bisiesto" : año + " no es bisiesto");

            for (int contadorAños = año; contadorAños <= 2024; contadorAños++) {
                if (Ejercicio4.añoBisiesto(contadorAños) == true) {
                    if (contadorAños != año) {
                        f.println(contadorAños);
                    }
                }
            };
            f.close();
        } catch (Exception e) {
            System.out.println("No se pudo crear el archivo.");
        }

        Scanner lector = new Scanner(new FileReader("Años_Bisiestos.txt"));
        lector.nextLine();

        while (lector.hasNextLine()) {
            String linea = lector.nextLine();
            System.out.printf("%-6s", linea);
        }

        lector.close();
        System.out.println();
        sc.close();
    };
};
