package dev.lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
    public void findWordsInFile(File file, String word) throws FileNotFoundException, IOException {

        if (!file.exists()) {
            throw new FileNotFoundException("El fichero al que intentas acceder no existe");
        }

        try (FileReader fr = new FileReader(file)) {
            int caracteresLeidos;
            int contador = 0;
            char[] buffer = new char[1024];

            while ((caracteresLeidos = fr.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, caracteresLeidos));
                
            }
            System.out.println(contador);
        }
    }
}
