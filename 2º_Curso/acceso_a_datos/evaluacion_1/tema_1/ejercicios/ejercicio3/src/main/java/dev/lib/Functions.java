package dev.lib;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Functions {

    private String COLOR_INICIO = "\033[1;34m";
    private String COLOR_CIERRE = "\033[0";
    private String rutaArchivo = "src/main/java/dev/alumnos.dat";

    public double solicitarReal(Scanner sc, String message) {

        double real;

        while (true) {
            System.out.print(message);
            String datoString = sc.nextLine().strip();

            if (datoString.isBlank()) {
                System.out.println("\033[41mError: El campo no puede estar vacio.\033[0m");
                continue;
            }

            try {
                real = Double.parseDouble(datoString);

                if (real <= 0) {
                    System.out.println();
                    System.out.println("\033[41mError: El número debe ser positivo. Inténtalo de nuevo.\033[0m");
                    System.out.println();
                    continue;
                }

                return real;
            } catch (Exception e) {
                System.out.println();
                System.out.println("\033[41mError: Debes introducir un número real válido.\033[0m");
                System.out.println();
                continue;
            }
        }
    }

    public int solicitarEntero(Scanner sc, String message) {

        int entero;

        while (true) {
            System.out.print(message);
            String datoString = sc.nextLine().strip();

            if (datoString.isBlank()) {
                System.out.println("\033[41mError: El campo no puede estar vacio.\033[0m");
                continue;
            }

            try {
                entero = Integer.parseInt(datoString);

                if (entero <= 0) {
                    System.out.println();
                    System.out.println("\033[41mError: El número debe ser positivo. Inténtalo de nuevo.\033[0m");
                    System.out.println();
                    continue;
                }

                return entero;
            } catch (Exception e) {
                System.out.println();
                System.out.println("\033[41mError: Debes introducir un número entero válido.\033[0m");
                System.out.println();
                continue;
            }
        }
    }

    public String solicitarCadena(Scanner sc, String message) {

        while (true) {
            System.out.print(message);
            String cadena = sc.nextLine().strip();

            if (cadena.isBlank()) {
                System.out.println();
                System.out.println("\033[41mError: El campo no puede estar vacio.\033[0m");
                System.out.println();
                continue;
            }

            return cadena.toLowerCase();
        }
    }

    public void escribirFicheroBinario(String name, double heigth) {

        try (FileOutputStream input = new FileOutputStream(rutaArchivo, true);
                DataOutputStream out = new DataOutputStream(input)) {

            int codigo = ((int) (Math.random() * 10000));

            out.writeInt(codigo);
            out.writeUTF(name);
            out.writeDouble(heigth);

        } catch (IOException e) {
            System.err.println("\033[41mError al escribir el fichero binario: \033[41m");
        }
    }

    public void leerFicheroBinario(String alumnoBuscado) {
        try (DataInputStream in = new DataInputStream(new FileInputStream(rutaArchivo))) {

            boolean encontrado = false;

            while (true) {
                try {
                    int codigo = in.readInt();
                    String nombre = in.readUTF();
                    double altura = in.readDouble();

                    if (alumnoBuscado == null || alumnoBuscado.isBlank()) {
                        System.out.printf("ID: %d | Nombre: %s | Altura: %.2f%n", codigo, nombre, altura);
                    } else if (nombre.equalsIgnoreCase(alumnoBuscado)) {
                        System.out.printf("Encontrado → ID: %d | Nombre: %s | Altura: %.2f%n", codigo, nombre, altura);
                        encontrado = true;
                    }

                } catch (EOFException e) {
                    break;
                }
            }

            if (alumnoBuscado != null && !alumnoBuscado.isBlank() && !encontrado) {
                System.out.println("\033[41mAlumno " + alumnoBuscado + " no encontrado.\033[0m");
            }

        } catch (IOException e) {
            System.err.println("Error al leer fichero: " + e.getMessage());
        }
    }

    public void editarEstudiante(int codigoBuscado, String nuevoNombre, double nuevaAltura) {
        String rutaTemp = "src/main/java/dev/data_temp.dat";

        try (DataInputStream in = new DataInputStream(new FileInputStream(rutaArchivo));
                DataOutputStream out = new DataOutputStream(new FileOutputStream(rutaTemp))) {

            boolean encontrado = false;

            while (true) {
                try {
                    int codigo = in.readInt();
                    String nombre = in.readUTF();
                    double altura = in.readDouble();

                    if (codigo == codigoBuscado) {
                        out.writeInt(codigo);
                        out.writeUTF(nuevoNombre);
                        out.writeDouble(nuevaAltura);
                        encontrado = true;
                    } else {
                        out.writeInt(codigo);
                        out.writeUTF(nombre);
                        out.writeDouble(altura);
                    }
                } catch (EOFException e) {
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("\033[41mAlumno con código " + codigoBuscado + " no encontrado.\033[0m");
            } else {
                System.out.println("\033[42mAlumno actualizado correctamente.\033[0m");
            }

            new File(rutaArchivo).delete();
            new File(rutaTemp).renameTo(new File(rutaArchivo));

        } catch (IOException e) {
            System.err.println("Error al editar estudiante: " + e.getMessage());
        }
    }

    public void borrarEstudiante(int codigoBuscado) {
        String rutaTemp = "src/main/java/dev/data_temp.dat";

        try (DataInputStream in = new DataInputStream(new FileInputStream(rutaArchivo));
                DataOutputStream out = new DataOutputStream(new FileOutputStream(rutaTemp))) {

            boolean encontrado = false;

            while (true) {

                try {
                    int codigo = in.readInt();
                    String nombre = in.readUTF();
                    double altura = in.readDouble();

                    if (codigo == codigoBuscado) {
                        encontrado = true;
                        continue;
                    }

                    out.writeInt(codigo);
                    out.writeUTF(nombre);
                    out.writeDouble(altura);

                } catch (EOFException e) {
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("\033[41mAlumno con código " + codigoBuscado + " no encontrado.\033[0m");
            } else {
                System.out.println("\033[42mAlumno eliminado correctamente.\033[0m");
            }

            new File(rutaArchivo).delete();
            new File(rutaTemp).renameTo(new File(rutaArchivo));

        } catch (IOException e) {
            System.err.println("Error al editar estudiante: " + e.getMessage());
        }
    }
}
