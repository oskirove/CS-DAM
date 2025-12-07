package dev.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Utils {
    public void findMoreUsedChar(File fichero) {

        if (!fichero.exists()) {
            System.out.println("ERROR: El fichero al que intentas acceder no existe.");
        }

        try (BufferedReader lector = new BufferedReader(new FileReader(fichero))) {
            int[] caracteres = new int[255];
            char[] buffer = new char[4096];

            int caracteresLeidos;

            while ((caracteresLeidos = lector.read(buffer)) != -1) {
                for (int i = 0; i < caracteresLeidos; i++) {
                    char c = buffer[i];
                    System.out.print(c);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
