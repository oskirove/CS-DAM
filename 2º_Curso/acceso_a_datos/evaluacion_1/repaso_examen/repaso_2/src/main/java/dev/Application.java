
package dev;

import java.io.File;

import dev.lib.Utils;

public class Application {
  public static void main(String[] args) {
    Utils functions = new Utils();
    functions.showStringLines(new File("repaso_2/src/main/java/dev/file.txt"), "Hoola muundoo!");
  }
}
