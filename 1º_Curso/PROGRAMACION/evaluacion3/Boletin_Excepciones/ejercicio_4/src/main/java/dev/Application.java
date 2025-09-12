
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
          System.out.println("1.- Crea una subcadena.");
          System.out.println("2.- Centra en la terminal una cadena de texto.");
          System.out.println("3.- Exit");

          System.out.print("Introduce una opción: ");
          option = sc.nextInt();

          switch (option) {
            case 1:
              String txt = Cadenas.solicitarCadena();
              int inicio = Funciones.solicitarEntero("Introduce un número entero: ", 1, 1000);
              int caracteres = Funciones.solicitarEntero("Introduce un segundo número entero: ", 1, 1000);
              Cadenas.subCadena(txt, inicio, caracteres);

              break;
            case 2:
              Cadenas.muestraCentrado(Cadenas.solicitarCadena());
              break;
            case 3:
              System.out.println("Saliendo del programa");
              break;
            default:
              System.out.println("Opcion no valida");
          }
        } while (option != 3);

        trigger = true;

      } catch (InputMismatchException e) {
        System.out.println("Debes introducir un número válido");
        sc.nextLine();
      }
    }
  }
}
