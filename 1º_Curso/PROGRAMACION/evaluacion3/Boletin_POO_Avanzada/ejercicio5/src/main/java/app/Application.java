
package app;

public class Application {
  public static void main(String[] args) {
    Astro astro = new Astro();
    astro.setNombre("Sol");
    System.out.println(astro.getNombre('_'));
  }
}
