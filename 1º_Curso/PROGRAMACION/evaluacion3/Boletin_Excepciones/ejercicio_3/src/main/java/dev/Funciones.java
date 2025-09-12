package dev;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Funciones {
    public static int solicitarEntero(String mensage, int inicio, int fin) {
        Scanner sc = new Scanner(System.in);

        int entero = 0;
        boolean trigger = false;

        while (!trigger) {
            try {
                System.out.print(mensage);
                entero = sc.nextInt();

                if (entero < inicio || entero > fin) {
                    throw new InputMismatchException("Error: Rango excedido.");
                }

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

    public static double solicitarReal(String mensage, int inicio, int fin) {
        Scanner sc = new Scanner(System.in);

        double real = 0;
        boolean trigger = false;

        while (!trigger) {
            try {
                System.out.print(mensage);
                real = sc.nextInt();

                if (real < inicio || real > fin) {
                    throw new InputMismatchException("Error: Rango excedido.");
                }

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
