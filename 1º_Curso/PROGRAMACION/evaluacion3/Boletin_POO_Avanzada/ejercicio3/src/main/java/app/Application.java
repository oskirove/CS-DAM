
package app;

public class Application {
  public static void main(String[] args) {
    Cadena cadena = new Cadena();
    cadena.setCadena("Hjoljja");
    System.out.println(cadena.toString());

    cadena.eliminar('j');

    System.err.println(cadena);
  }
}
