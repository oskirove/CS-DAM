package dev.lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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

    public void splitFileByLines(File file, int lines) {
        if (!file.exists()) {
            System.out.println("ERROR: El fichero al que intentas acceder no existe.");
        }

        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(file)))) {
            int acum = 0;

            while (sc.hasNextLine()) {
                acum++;

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("fichero-" + acum))) {

                    for (int i = 0; i < lines && sc.hasNextLine(); i++) {
                        bw.write(sc.nextLine() + "\n");
                    }
                }
            }

            for (int i = 0; i < lines; i++) {
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
