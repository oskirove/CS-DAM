
package examen;

public class Application {
  public static void main(String[] args) {

    int[][] matriz = Funciones.creaMatriz(4);

    Funciones.muestraMatriz(matriz);

    Funciones.intercambioDePoder(matriz, 1, 2);

    Funciones.muestraMatriz(matriz);

  }
}
