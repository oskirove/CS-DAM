package dev;

import java.io.File;
import java.io.IOException;

import dev.lib.funciones;

public class Application {
  public static void main(String[] args) throws IOException {

    funciones.dividirFicheroPorLineas(new File("src/main/java/dev/fichero.txt"), 3);
    
    // funciones.dividirFicheroPorCaracteres(new File("src/main/java/dev/fichero.txt"), 200);
  }
}
