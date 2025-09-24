package dev.lib;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class funciones {

    public static void dividirFicheroPorLineas(File file, int lines) throws IOException {
        try (Scanner sc = new Scanner(file)) {
            String[] buffer = new String[lines];
            
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
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
}
