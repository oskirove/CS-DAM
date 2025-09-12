
package dev;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import dev.Geometria.*;
import dev.exceptions.CollectionIsEmptyException;
import dev.interfaz.Libreria;

public class Application {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    ArrayList<Figura> coleccion = new ArrayList<Figura>();

    Integer option = 0;

    do {
      System.out.println();
      System.out.println("------------------ MENÚ ------------------");
      System.out.println();
      System.out.println("1.- Insertar una línea, un triángulo un cuadrado o una circunferencia.");
      System.out.println("2.- Mostrar los elementos de la colección.");
      System.out.println("3.- Mostrar los datos de un elemento de la colección.");
      System.out.println("4.- Borrar elementos de un tipo.");
      System.out.println("5.- Salir");
      System.out.println();

      try {

        option = Libreria.pedirEntero("Introduce una opción: ");

      } catch (InputMismatchException e) {
        System.out.println();
        if (e.getMessage() == null) {
          System.out.println("Error: Introduce una valor correcto");
        }
        sc.nextLine();
      }

      switch (option) {
        case 1:
          int option2;
          do {
            System.out.println();
            System.out.println("---- SELECCIONA EL TIPO DE FIGURA ----");
            System.out.println();
            System.out.println("1.- Insertar Poligono.");
            System.out.println("2.- insertar linea.");
            System.out.println("3.- insertar circunferencia.");
            System.out.println("4.- Volver");

            System.out.println();
            option2 = Libreria.pedirEntero("Introduce una opción: ");

            switch (option2) {
              case 1:
                Poligono poligono = new Poligono();
                poligono.pedirDatos();
                coleccion.add(poligono);
                break;
              case 2:
                Linea linea = new Linea();
                linea.pedirDatos();
                coleccion.add(linea);
                break;
              case 3:
                try {
                  Circunferencia circunferencia = new Circunferencia();
                  circunferencia.pedirDatos();
                  coleccion.add(circunferencia);
                } catch (Exception e) {// TODO excepcion no genérica
                  System.out.println(e.getMessage());
                }
                break;
              case 4:
                System.out.println("Saliendo del programa");
                break;
              default:
                System.out.println();
                System.out.println("Opción no válida");
            }
          } while (option2 != 4);
          break;
        case 2:
          try {

            if (coleccion.size() == 0) {
              throw new CollectionIsEmptyException("La colección está vacía");
            }

            System.out.println();
            System.out.println("----- COLECCIÓN DE FIGURAS -----");// TODO diferenciar circunf
            System.out.println();
            for (Figura row : coleccion) {
              row.mostrarDatos();
              System.out.println("------------------");
            }

          } catch (Exception e) {// TODO exc no generica
            System.out.println();
            System.out.println(e.getMessage());
          }
          break;
        case 3:
          boolean trigger = false;
          try {

            if (coleccion.size() != 0) {

              while (!trigger) {

                System.out.println();
                int index = Libreria.pedirEntero("Introduce el indice del objeto que quieres ver: ");
                System.out.println();

                if (index >= coleccion.size() || index < 0) {
                  throw new IndexOutOfBoundsException(
                      "El índice no puede ser mayor que " + coleccion.size() + " ni menor que 0");
                }

                coleccion.get(index).mostrarDatos();

                trigger = true;
              }
            } else {
              System.out.println("Coleccion vacia");
            }
          } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
          }

          break;
        case 4:
          boolean trigger4 = false;

          try {

            if (coleccion.size() == 0) {
              throw new CollectionIsEmptyException("La colección está vacía");
            }

            while (!trigger4) {

              System.out.println();
              System.out.println("Tipos de figura: Poligono | Linea | Circunferencia");
              System.out.print("Escribe el tipo que quieres eliminar: ");
              sc.nextLine();
              String cadena = sc.nextLine().toUpperCase().trim();

              if (!cadena.equals("POLIGONO") && !cadena.equals("LINEA") && !cadena.equals("CIRCUNFERENCIA")) {
                throw new InputMismatchException("Error: debes introducir un tipo de figura válido.");
              }

              System.out.println();

              for (int i = coleccion.size() - 1; i >= 0; i--) {
                Figura figura = coleccion.get(i);
                System.out.println();
                if (cadena.equals(figura.getClass().getSimpleName().toUpperCase())) {// TODO comparar por clases
                                                                                     // (polimorfismo)
                  coleccion.remove(i);
                }
              }

              trigger4 = true;
            }

          } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
          }

          break;
        case 5:
          System.out.println("Saliendo del programa");
          break;
        default:
          System.out.println();
          System.out.println("Opción no válida");
      }

    } while (option != 5);
  }
}
