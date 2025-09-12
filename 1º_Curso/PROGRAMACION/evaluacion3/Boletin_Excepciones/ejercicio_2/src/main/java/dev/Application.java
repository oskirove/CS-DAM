
package dev;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
  public static void main(String[] args) {

    Geometria triangulo = new Geometria();

    Scanner sc = new Scanner(System.in);
    double base = 0;
    double altura = 0;
    boolean trigger = false;
    while (!trigger) {
      try {
        boolean triggerBase = false;
        while (!triggerBase) {
          try {
            System.out.print("Introduce la base del triángulo: ");
            base = sc.nextDouble();
            triangulo.setBase(base);

            triggerBase = true;
          } catch (InputMismatchException e) {
            System.out.println("Error: Valor no permitido.");
            sc.nextLine();
          }
        }

        boolean triggerAltura = false;
        while (!triggerAltura) {
          try {
            System.out.print("Introduce la altura del triángulo: ");
            altura = sc.nextDouble();
            triangulo.setAltura(altura);

            triggerAltura = true;
          } catch (InputMismatchException e) {
            System.out.println("Error: Valor no permitido.");
            sc.nextLine();
          }
        }

        trigger = true;

      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        sc.nextLine();
      }
    }

    System.out.printf("La altura del triangulo es %.2f%n", triangulo.getAltura());
    System.out.printf("El area del triangulo es %.2f%n", triangulo.area());

    sc.close();
  }
}
