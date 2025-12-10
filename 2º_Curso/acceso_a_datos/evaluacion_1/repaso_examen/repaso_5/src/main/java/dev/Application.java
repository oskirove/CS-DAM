
package dev;

import java.io.File;

import dev.lib.Utils;

public class Application {
  public static void main(String[] args) {
    Utils u = new Utils();
    u.replaceWords(new File("repaso_5/src/main/java/dev/fichero.txt"), "hola", "adios");
  }
}
