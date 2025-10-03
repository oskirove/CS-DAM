
package model;

import java.util.ArrayList;
import java.util.Scanner;

import model.lib.GestorFicheros;
import model.lib.Utils;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Utils funciones = new Utils();
        GestorFicheros ficheros = new GestorFicheros();

        ArrayList<Persona> coleccionPersonas = new ArrayList<>();
        ArrayList<Depart> coleccionDeparts = new ArrayList<>();

        int option;

        do {
            System.out.println();
            System.out.println("\033[45m---- GESTOR DE DEPARTAMENTOS Y TRABAJADORES ----\033[0m");
            System.out.println();
            System.out.println("1.- \033[1;35mAgregar trabajador.\033[0m");
            System.out.println("2.- \033[1;35mAgregar departamento.\033[0m");
            System.out.println("3.- \033[1;35mVer información de un usuario.\033[0m");
            System.out.println("4.- \033[1;35mVer todos los usuarios.\033[0m");
            System.out.println("5.- \033[1;35mVer departamentos.\033[0m");
            System.out.println("6.- \033[1;35mSalir del gestor\033[0m");
            System.out.println();
            option = funciones.solicitarEntero(sc, "Introduce una opción: ");
            System.out.println();

            switch (option) {
                case 1:
                    String nombreTrabajador = funciones.solicitarCadena(sc, "Introduce un nombre: ");
                    String departamentoTrabajador = funciones.solicitarCadena(sc, "Introduce el departamento: ");
                    int edadTrabajador = funciones.solicitarEntero(sc, "Introduce una edad: ");

                    Persona trabajador = new Persona(nombreTrabajador, edadTrabajador, null);
                    coleccionPersonas.add(trabajador);

                    ficheros.escribirPersonas(coleccionPersonas);
                    break;
                case 2:
                    String nombreDepartamento = funciones.solicitarCadena(sc, "Introduce el nombre del departamento: ");
                    Depart departamento = new Depart(nombreDepartamento);

                    coleccionDeparts.add(departamento);
                    ficheros.escribirDepartamentos(coleccionDeparts);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Abandonando Gestor");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (option != 5);
    }
}
