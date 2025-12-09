package dev.lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Utils {
    public void replaceWords(File file, String word, String wordToChange) {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(file)))) {

            String linea;

            while (sc.hasNextLine()) {
                linea = sc.nextLine();

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("archivo_generado"))) {
                    String newLine = linea.replace(word, wordToChange);
                    bw.write(newLine);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
