
package dev;

import dev.lib.Utils;

public class Application {
  public static void main(String[] args) {

    try {
      Utils utils = new Utils();
      utils.showContentFromTxtFile("src/main/java/dev/resources");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
