package dev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

    public void findCharacter(File file, char character) throws FileNotFoundException {

        if (!file.exists()) {
            throw new FileNotFoundException("ERROR: No se ha encontrado el fichero al que intentas acceder.");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int cont = 0;
            char[] buffer = new char[1];

            while ((br.read(buffer)) != -1) {
                if (buffer[0] == character) {
                    cont++;
                }
            }

            System.out.println(cont);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
