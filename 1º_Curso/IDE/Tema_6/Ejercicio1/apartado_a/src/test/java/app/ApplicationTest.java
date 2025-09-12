
package app;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Application")
public class ApplicationTest {

  @Test
  @DisplayName("Bisiesto")
  void añoBisiesto() {
    assertFalse(ApartadoA.añoBisiesto(1800), "1800 no es bisiesto");
    assertTrue(ApartadoA.añoBisiesto(2000), "2000 sí es bisiesto");
    assertTrue(ApartadoA.añoBisiesto(2004), "2004 sí es bisiesto");
    assertFalse(ApartadoA.añoBisiesto(2006), "2006 no es bisiesto");
    assertFalse(ApartadoA.añoBisiesto(2021), "2021 no es bisiesto");
  }
}
