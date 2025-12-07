
package dev;

import java.io.File;

import dev.lib.Utils;

public class Application {
  public static void main(String[] args) {
    Utils u = new Utils();
    u.findMoreUsedChar(new File("repaso_3/src/main/java/dev/file.txt"));
  }
}
