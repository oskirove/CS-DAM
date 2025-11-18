
package dev;

import dev.lib.Utils;

public class Application {
  public static void main(String[] args) {
    Utils utils = new Utils();
    System.out.println();
    System.out.println("Temporada: " + utils.getTemporada());
    System.out.println("Número de partidos: " + utils.getNumPartidos());
    System.out.println("Máximos goleadores:");
    utils.mostrarEquipoMaxGoles(utils.getMaxGoles());
    System.out.println();
    utils.getNombreEquiposFechas();
    System.out.println();
  }
}
