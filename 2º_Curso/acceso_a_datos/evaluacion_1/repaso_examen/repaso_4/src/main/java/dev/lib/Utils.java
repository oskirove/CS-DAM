package dev.lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public void splitFileByChars(File file, int characters) {
        if (!file.exists()) {
            System.out.println("ERROR: El fichero al que intentas acceder no existe.");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            char buffer[] = new char[characters];
            int caracteresLeidos;
            int acum = 0;

            while ((caracteresLeidos = br.read(buffer)) != -1) {
                acum++;
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("fichero-" + acum))) {

                    bw.write(new String(buffer, 0, caracteresLeidos));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
