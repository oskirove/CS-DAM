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
                System.out.println("Debes introducir un número válido");
                System.out.println("Error: " + e.getMessage());
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
            System.out.println("Error: " + e.getMessage());
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

    public static void fusionarDocs(File archivo) {
        File[] lista = archivo.listFiles();
        
        System.out.println();

        for (File file : lista) {
            System.out.println(file.getName());
        }
        System.out.println();
    }
}
