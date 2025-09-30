package dev.lib;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class funciones {

    public static int solicitarOpcion(String mensaje) {
        Scanner sc = new Scanner(System.in);

        boolean trigger = false;

        int opcion = 0;

        while (!trigger) {
            System.out.print(mensaje);
            String texto = sc.nextLine();

            try {
                opcion = Integer.parseInt(texto);
                System.out.println();
                trigger = true;
            } catch (IllegalArgumentException e) {
                System.out.println("\33[31mError: Debes introducir un número válido\33[0m");
            }
        }

        return opcion;
    }

    public static void dividirFicheroPorLineas(File file, int lineas) throws IOException {

        int contadorArchivos = 1;
        int contadorLineas = 0;
        PrintWriter escritor = null;

        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {
                if (contadorLineas == 0) {
                    String nombresFicheros = "fichero" + contadorArchivos + ".txt";
                    escritor = new PrintWriter(new FileWriter(nombresFicheros));
                }

                escritor.println(sc.nextLine());
                contadorLineas++;

                if (contadorLineas == lineas) {
                    escritor.close();
                    contadorLineas = 0;
                    contadorArchivos++;
                }
            }

            if (contadorLineas > 0 && escritor != null) {
                escritor.close();
            }

        } catch (IOException e) {
            System.out.println("\33[31mError: " + e.getMessage() + "\33[0m");
        } finally {
            if (escritor != null) {
                escritor.close();
            }
        }
    }

    public static void dividirFicheroPorCaracteres(File file, int characters) throws IOException {
        try (FileReader lector = new FileReader(file)) {
            char buffer[] = new char[characters];
            int i;
            int indice = 1;
            while ((i = lector.read(buffer)) != -1) {
                try (FileWriter escritor = new FileWriter("fichero" + indice + ".txt")) {
                    for (int j = 0; j < i; j++) {
                        escritor.write(buffer[j]);
                    }
                }
                indice++;
            }
            System.out.println();
        }
    }

    public static void fusionarDocs(File archivo) throws IOException {

        if (!archivo.isDirectory()) {
            System.out.println();
            System.out.println("\33[41mError: el archivo no es válido o no existe\33[0m");
        }

        File[] lista = archivo.listFiles();

        System.out.println();

        if (lista != null) {
            try (PrintWriter escritor = new PrintWriter(new FileWriter("ficheroFusionado.txt", true))) {
                for (File file : lista) {
                    try (Scanner sc = new Scanner(file);) {

                        while (sc.hasNextLine()) {
                            escritor.print(sc.nextLine() + " ");
                        }

                    } catch (IOException e) {
                        System.out.println("\33[31mError al leer el fichero " + file.getName() + "\33[0m");
                    }
                }
            } catch (IOException e) {
                System.out.println("\33[31mError al crear o escribir en el fichero de fusion \33[0m");
            }
        } else {
            System.out.println("\33[31mNo se han podido leer los ficheros del directorio\33[0m");
        }
    }
}
