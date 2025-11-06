package dev;

import dev.lib.Functions;

// Usar esto en la terminal: export API_KEY_OPEN_WEATHER_MAP="la-clave-de-api" 
// export API_KEY_TICKET_MASTER="la-clave-api"

public class Application {
  public static void main(String[] args) {

    try {
      Functions functions = new Functions();
      
      // Inicializar Api de Open Weather Map
      // Functions.initializeApiKey();
      
      // Ejercicio 1
      // functions.getTiempoCiudad("Vigo");

      // Ejercicio 2
      // functions.getTiempoCoords(42.33669 , -7.86407);

      // Ejercicio 3
      // functions.getTiempoCiudades(42.33669 , -7.86407, 3);

      // Ejercicio 4
      // functions.getCityID("Ourense");

      // Ejercicio 5
      // functions.getCityName(42.33669 , -7.86407);

      // Ejercicio 6
      // functions.getCityCo("Ourense");

      // Ejercicio 7
      // functions.pronosticoCompleto("Ourense");

      // Ejercicio 8
      // functions.pronosticoCompletoCiudades(42.33669 , -7.86407, 8);
      
      // Ejercicio 9
      // functions.mostrarPreguntas();

      // Ejercicio 10
      // Functions.initializeApiKeyTicketMaster();
      // functions.mostrarEventosPais("ES");

      // Ejercicio 11
      functions.getIdEventosPais("ES");
      
      System.out.println();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}