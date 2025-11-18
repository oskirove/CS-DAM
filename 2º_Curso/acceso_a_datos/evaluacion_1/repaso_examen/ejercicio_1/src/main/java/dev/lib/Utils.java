package dev.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Utils {
    public void showContentFromTxtFile(String path) throws FileNotFoundException {
        
        File directory = new File(path);

        if (!directory.exists()) {
            throw new FileNotFoundException("Error el archivo al que intentas acceder no existe");
        }

        File[] files = directory.listFiles();

        ArrayList<String> filePaths = getTxtFilePathsFromDir(files);

        for (String filePath : filePaths) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

                String line;

                System.out.println();
                System.out.println("Archivo:" + filePath);
                System.out.println();

                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private ArrayList<String> getTxtFilePathsFromDir(File[] files) {

        ArrayList<String> paths = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            if (files[i].getAbsolutePath().endsWith(".txt")) {
                paths.add(files[i].getAbsolutePath());
            }
        }

        return paths;
    }
}
