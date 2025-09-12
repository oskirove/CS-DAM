package dev.interfaz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Libreria {

    public static int pedirEntero(String mensage) {
        Scanner sc = new Scanner(System.in);

        int entero = 0;
        boolean trigger = false;

        while (!trigger) {
            try {
                System.out.print(mensage);
                entero = sc.nextInt();

                trigger = true;
            } catch (InputMismatchException e) {
                if (e.getMessage() == null) {
                    System.out.println();
                    System.out.println("Error: Valor no admitido.");
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println(e.getMessage());
                    System.out.println();
                }
                sc.nextLine();
            }
        }

        return entero;
    }

    public static double pedirReal(String mensage) {
        Scanner sc = new Scanner(System.in);

        double real = 0;
        boolean trigger = false;

        while (!trigger) {
            try {
                System.out.print(mensage);
                real = sc.nextDouble();

                trigger = true;
            } catch (InputMismatchException e) {
                if (e.getMessage() == null) {
                    System.out.println();
                    System.out.println("Error: Valor no admitido.");
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println(e.getMessage());
                    System.out.println();
                }
                sc.nextLine();
            }
        }

        return real;
    }
}
