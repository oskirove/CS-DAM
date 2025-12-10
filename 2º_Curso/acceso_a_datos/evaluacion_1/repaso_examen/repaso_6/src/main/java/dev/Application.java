
package dev;

import java.io.IOException;
import java.util.Scanner;

import dev.lib.Utils;

public class Application {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int option;
    Utils u = new Utils();
    do {
      System.out.println("1.- Dar de alta a un alumno");
      System.out.println("2.- Consultar alumnos");
      System.out.println("3.- Modificar alumnos");
      System.out.println("4.- Borrar alumnos");
      System.out.println("5.- Salir");
      option = sc.nextInt();
      switch (option) {
        case 1:
          System.out.println("Introduce la edad: ");
          int edad = sc.nextInt();
          sc.nextLine();
          System.out.println("Introduce el nombre: ");
          String name = sc.nextLine();

          u.addEstudent(name, edad);
          break;
        case 2:
          u.showEstudents();
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          System.out.println("Saliendo del programa");
          break;
        default:
          System.out.println("Opcion no valida");
      }
    } while (option != 5);
  }
}
