
package dev;

import java.util.Scanner;
import dev.lib.Functions;

public class Application {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Functions funciones = new Functions();

    int option;

    do {
      System.out.println();
      System.out.println("\033[45m---GESTOR DE ALUMNOS---\033[0m");
      System.out.println();
      System.out.println("1.- \033[1;35mDar de alta nuevos alumnos.\033[0m");
      System.out.println("2.- \033[1;35mConsultar alumnos.\033[0m");
      System.out.println("3.- \033[1;35mModificar alumnos.\033[0m");
      System.out.println("4.- \033[1;35mBorrar alumnos.\033[0m");
      System.out.println("5.- \033[1;35mSalir\033[0m");
      System.out.println();
      System.out.print("Introduce una opción: ");
      option = sc.nextInt();
      sc.nextLine();
      System.out.println();

      switch (option) {
        case 1:

          String name = funciones.solicitarCadena(sc, "Introduce el nombre del estudiante: ");
          double heigth = funciones.solicitarReal(sc, "Introduce la altura del estudiante: ");

          funciones.escribirFicheroBinario(name, heigth);

          break;
        case 2:

          String alumno = funciones.solicitarCadena(sc, "Introduce el nombre del estudiante: ");
          System.out.println();
          System.out.println("Los datos son: ");
          funciones.leerFicheroBinario(alumno);

          break;
        case 3:
          int ID = funciones.solicitarEntero(sc, "Introduce el ID del estudiante a modificar: ");
          String nuevoNombre = funciones.solicitarCadena(sc, "Introduce el nuevo nombre del estudiante: ");
          double altura = funciones.solicitarReal(sc, "Introduce la nueva estatura del estudiante: ");

          funciones.editarEstudiante(ID, nuevoNombre, altura);
          break;
        case 4:
          int IDBorrar = funciones.solicitarEntero(sc, "Introduce el ID del estudiante a modificar: ");
          funciones.borrarEstudiante(IDBorrar);
          break;
        case 5:
          System.out.println("Saliendo del programa");
          break;
        default:
          System.out.println("Opcion no valida");
      }
    } while (option != 5);

    sc.close();
  }
}
