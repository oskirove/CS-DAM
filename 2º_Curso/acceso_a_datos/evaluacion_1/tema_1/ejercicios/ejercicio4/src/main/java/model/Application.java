
package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import model.lib.GestorFicheros;
import model.lib.Utils;

public class Application {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);

        Utils funciones = new Utils();
        GestorFicheros ficheros = new GestorFicheros();

        /**
         * Inicializamos las colecciones agregandole los
         * valores ya existentes en los ficheros.
         */
        ArrayList<Persona> coleccionPersonas = ficheros.leerTrabajadores();
        ArrayList<Depart> coleccionDeparts = ficheros.leerDepartamentos();

        int option;

        do {
            System.out.println();
            System.out.println("\033[45m---- GESTOR DE DEPARTAMENTOS Y TRABAJADORES ----\033[0m");
            System.out.println();
            System.out.println("1.- \033[1;35mAgregar trabajador.\033[0m");
            System.out.println("2.- \033[1;35mAgregar departamento.\033[0m");
            System.out.println("3.- \033[1;35mEliminar un usuario.\033[0m");
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

                    Depart dptoAsignado = null;
                    for (Depart d : coleccionDeparts) {
                        if (d.getName().equalsIgnoreCase(departamentoTrabajador)) {
                            dptoAsignado = d;
                            break;
                        }
                    }

                    UUID idDepartamento = null;

                    if (dptoAsignado != null) {
                        idDepartamento = dptoAsignado.getDepartmentID();
                        System.out.println("Trabajador asignado al departamento: " + dptoAsignado.getName());
                    } else {
                        System.out.println(
                                "\033[43mAdvertencia: Departamento no encontrado. Trabajador sin asignar.\033[0m");
                    }

                    Persona trabajador = new Persona(nombreTrabajador, edadTrabajador, idDepartamento);
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

                    String usuarioEliminar = funciones.solicitarCadena(sc,
                            "Introduce el nombre del usuario que quieres eliminar: ");
                    ficheros.eliminarTrabajadores(usuarioEliminar, coleccionPersonas);

                    break;
                case 4:

                    for (Persona p : coleccionPersonas) {

                        String nombrePorId = ficheros.vincularIdDepartamentoConNombre(coleccionDeparts,
                                p.getDepartmentID());
                        System.out.printf("ID:%s\n Nombre: %s\n Edad: %s\n Departamento: %s\n", p.getUserID(),
                                p.getName(), p.getAge(), nombrePorId);
                    }

                    break;
                case 5:
                    for (Depart d : coleccionDeparts) {
                        System.out.println(d);
                    }
                    break;
                case 6:
                    System.out.println("Abandonando Gestor");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (option != 6);
    }
}
