package dev;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int option;
    boolean trigger = false;
    while (!trigger) { 
      try {
        do {
          System.out.println("1.- Convierte de libras a euros");
          System.out.println("2.- Convierte de euros a libras");
          System.out.println("3.- Exit");
          System.out.print("Introduce una opción: ");
          option = sc.nextInt();

          switch (option) {
            case 1:
              double libras = 0;
              boolean triggerLibras = false;
              while (!triggerLibras) {
                try {
                  System.out.print("Introduce la cantidad de libras: ");
                  libras = sc.nextDouble();
                  triggerLibras = true;
                } catch (InputMismatchException e) {
                  System.out.println("Por favor, introduce un número válido.");
                  sc.nextLine();
                }
              }
              System.out.printf("Son %.2f€%n", Conversor.librasAEuros(libras));
              break;

            case 2:
              double euros = 0;
              boolean triggerEuros = false;
              while (!triggerEuros) {
                try {
                  System.out.print("Introduce la cantidad de euros: ");
                  euros = sc.nextDouble();
                  triggerEuros = true;
                } catch (InputMismatchException e) {
                  System.out.println("Por favor, introduce un número válido.");
                  sc.nextLine();
                }
              }
              System.out.printf("Son %.2f£%n", Conversor.eurosALibras(euros));
              break;

            case 3:
              System.out.println("Saliendo del programa");
              break;

            default:
              System.out.println("Opción no válida");
          }
        } while (option != 3);
        trigger = true;
      } catch (InputMismatchException e) {
        System.out.println("Por favor, introduce un número válido.");
        sc.nextLine();
      }
    }
  }
}
