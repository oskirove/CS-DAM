
package dev;

import dev.lib.Functions;

public class Application {
  public static void main(String[] args) {
    Functions f = new Functions();

    //f.mostrarTitulosPeliculas();

    //f.mostrarInfoPeliculas();

    //f.mostrarNDirectores(2);

    String tit = "Cars";
    String director = "Walt Disney";
    String gen = "Carreras";

    f.modificarDOM(tit, director, gen);
  }
}
