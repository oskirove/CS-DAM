package app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CadenaTest {

    private static Cadena cadena;

    @BeforeAll
    public static void setUp() {
        cadena = new Cadena();
        cadena.setCadena("cadena");
    }

    @Test
    public void testEqualsConOtraCadenaIgual() {
        Cadena otra = new Cadena();
        otra.setCadena("cadena");
        assertTrue(cadena.equals(otra));
    }

    @Test
    public void testEqualsConStringIgual() {
        assertTrue(cadena.equals("cadena"));
    }

    @Test
    public void testEqualsConCharArrayIgual() {
        char[] letras = { 'c', 'a', 'd', 'e', 'n', 'a' };
        assertTrue(cadena.equals(letras));
    }

    @Test
    public void testEqualsConCadenaDiferente() {
        Cadena otra = new Cadena();
        otra.setCadena("cadenas");
        assertFalse(cadena.equals(otra));
    }

    @Test
    public void testEqualsConStringDiferente() {
        assertFalse(cadena.equals("cadenas"));
    }

    @Test
    public void testEqualsConCharArrayDiferente() {
        char[] letras = { 'c', 'a', 'd', 'e' };
        assertFalse(cadena.equals(letras));
    }

    @Test
    public void testEqualsConNullLanzaExcepcion() {
        try {
            cadena.equals(null);
            fail("Se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("El objeto no puede ser null", e.getMessage());
        }
    }

    @Test
    public void testEqualsConTipoIncompatible() {
        try {
            cadena.equals(123);
            fail("Se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Este objeto no es compatible", e.getMessage());
        }
    }

    @Test
    public void testEliminarCaracterExistente() {
        Cadena copia = new Cadena();
        copia.setCadena("cadena");
        copia.eliminar('a');
        assertEquals("cden", copia.toString());
    }

    @Test
    public void testEliminarCaracterNoExistente() {
        Cadena copia = new Cadena();
        copia.setCadena("cadena");
        copia.eliminar('x');
        assertEquals("cadena", copia.toString());
    }

    @Test
    public void testEliminarTodosLosCaracteres() {
        Cadena copia = new Cadena();
        copia.setCadena("aaa");
        copia.eliminar('a');
        assertEquals("", copia.toString());
    }

    @Test
    public void testEliminarCaracterEnCadenaVacia() {
        Cadena vacia = new Cadena();
        vacia.setCadena("");
        vacia.eliminar('a');
        assertEquals("", vacia.toString());
    }
}