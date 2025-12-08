
package dev;

import java.io.File;

import dev.lib.Utils;

public class Application {
  public static void main(String[] args) {
    Utils u = new Utils();

    //u.splitFileByChars(new File("repaso_4/src/main/java/dev/file.txt"), 10);
    u.splitFileByLines(new File("repaso_4/src/main/java/dev/file.txt"), 3);

    
  }
}
