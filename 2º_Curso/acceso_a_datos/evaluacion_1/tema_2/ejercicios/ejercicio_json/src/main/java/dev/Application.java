package dev;

import dev.lib.Functions;

// Usar esto en la terminal: export API_KEY="la-clave-de-api"

public class Application {

  public static void main(String[] args) {
    try {
      Functions.initializeApiKey();
      Functions functions = new Functions();

      System.out.println(functions.getTiempoCiudad("Ourense"));

      System.out.println();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
