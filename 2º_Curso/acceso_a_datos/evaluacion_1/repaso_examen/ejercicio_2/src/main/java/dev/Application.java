package dev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import dev.lib.Utils;

public class Application {
  public static void main(String[] args) {
    Utils utils = new Utils();

    File file = new File("fichero.txt");
    
    try {
      utils.findWordsInFile(file, "mundo");

    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
