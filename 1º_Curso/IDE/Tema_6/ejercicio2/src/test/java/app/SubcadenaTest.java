
package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("test subcadena")
public class SubcadenaTest {

  static String texto;

  @BeforeAll
  static void init() {
    texto = "Hola";
  }

  @Test
  void afirmacion1() {
    assertEquals("Hola", Subcadena.subCadena(texto, 0, 4));
  }

  @Test
  void afirmacion2() {
    try {
      Subcadena.subCadena(texto, 0, 5);
      fail("Se esperaba IndexOutOfBoundsException pero no se lanzó");
    } catch (IndexOutOfBoundsException e) {
      // OK
    }
  }

  @Test
  void afirmacion3() {
    assertEquals("a", Subcadena.subCadena(texto, 3, 1));
  }

  @Test
  void afirmacion4() {
    try {
      Subcadena.subCadena(texto, 4, 1);
      fail("Se esperaba IndexOutOfBoundsException pero no se lanzó");
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  @Test
  void afirmacion5() {
    assertEquals("ol", Subcadena.subCadena(texto, 1, 2));
  }

  @Test
  void afirmacion6() {
    try {
      Subcadena.subCadena(texto, 3, -1);
      fail("Se esperaba illegalargument pero no se lanzó");
    } catch (IllegalArgumentException e) {
      // TODO: handle exception
    }
  }

  @Test
  void afirmacion7() {
    try {
      Subcadena.subCadena(texto, -3, 3);
      fail("Se esperaba illegalargument pero no se lanzó");
    } catch (IllegalArgumentException e) {
      // TODO: handle exception
    }
  }
}
