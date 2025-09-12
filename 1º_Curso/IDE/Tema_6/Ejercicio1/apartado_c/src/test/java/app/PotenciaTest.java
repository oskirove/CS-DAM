
package app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Prueba clase potencia")
public class PotenciaTest {

  @Test
  @DisplayName("Test para la funcion potencia")
  void testPotencia() {
    assertEquals(8.0, Potencia.potencia(2, 3));
    assertEquals(1.0, Potencia.potencia(5, 0));
    assertEquals(0.0, Potencia.potencia(0, 5));
    assertEquals(-8.0, Potencia.potencia(-2, 3));
    assertEquals(4.0, Potencia.potencia(-2, 2));
  }
}