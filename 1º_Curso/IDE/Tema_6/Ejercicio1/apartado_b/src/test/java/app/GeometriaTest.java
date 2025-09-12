
package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test para la clase geometria")
public class GeometriaTest {

  @Test
  @DisplayName("Superficie cilindro")
  void testSuperficieCilindro() {
    double esperado = 2 * 3.1416 * 1 * (1 + 1);
    double actual = Geometria.superficieCilindro(1, 1);

    assertEquals(esperado, actual, 0.00001, "El resultado no ha sido el esperado");
  }
}
