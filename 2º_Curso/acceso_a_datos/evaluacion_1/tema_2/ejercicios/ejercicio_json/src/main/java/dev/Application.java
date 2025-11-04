package dev;

import dev.lib.Functions;

// Usar esto en la terminal: export API_KEY="la-clave-de-api"

public class Application {
  
  public static void main(String[] args) {
    try {
      Functions.initializeApiKey();
      Functions functions = new Functions();

      // Ejercicio 1
      // functions.getTiempoCiudad("Vigo");

      // Ejercicio 2
      // functions.getTiempoCoords(42.33669 , -7.86407);

      // Ejercicio 3
      // functions.getTiempoCiudades(42.33669 , -7.86407, 3);

      // Ejercicio 4
      // functions.getCityID("Ourense");

      // Ejercicio 5
      functions.getCityName(42.33669 , -7.86407);
      System.out.println();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
