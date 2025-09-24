package dev;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import dev.lib.funciones;

public class Application {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    int opcion = 0;

    do {
      System.out.println("1.- Dividir fichero por lineas.");
      System.out.println("2.- Dividir fichero por caracteres.");
      System.out.println("3.- Fusionar documentos de un archivo en uno.");
      System.out.println("4.- Salir.");

      opcion = funciones.solicitarOpcion("Introduce un número: ");

      switch (opcion) {
        case 1:

          int lineas = funciones.solicitarOpcion("Introduce el número de lineas: ");
          funciones.dividirFicheroPorLineas(new File("src/main/java/dev/fichero.txt"), lineas);

          break;
        case 2:

          int caracteres = funciones.solicitarOpcion("Introduce el número de caracteres: ");
          funciones.dividirFicheroPorCaracteres(new File("src/main/java/dev/fichero.txt"), caracteres);

          break;
        case 3:
          System.out.println("Introduce la ruta relativa del archivo: ");
          String archivo = sc.nextLine();
          
          funciones.fusionarDocs(archivo);
          break;
        case 4:

          break;
        default:
          System.out.println("Opción no válida");
          break;
      }

    } while (opcion != 4);
  }
}