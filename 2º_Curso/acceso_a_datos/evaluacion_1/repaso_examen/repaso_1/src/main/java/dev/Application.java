
package dev;

import java.io.File;
import java.io.FileNotFoundException;

public class Application {
  public static void main(String[] args) throws FileNotFoundException {
    Utils functions = new Utils();

    functions.findCharacter(new File("repaso_1/src/main/java/dev/file.txt"), 'o');
  }
}
