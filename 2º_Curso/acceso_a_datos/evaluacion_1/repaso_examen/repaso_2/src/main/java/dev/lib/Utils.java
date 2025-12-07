package dev.lib;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Utils {
    public void showStringLines(File fichero, String cadena) {

        if (!fichero.exists()) {
            System.out.println("ERROR: El fichero al que intentas acceder no existe.");
        }

        try (Scanner sc = new Scanner(fichero)) {
            String linea;
            int cont = 0;
            while (sc.hasNext()) {
                cont++;
                linea = sc.nextLine();
                if (linea.equals(cadena)) {
                    System.out.printf("%s aparece en la linea: %d\n", linea, cont);
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
