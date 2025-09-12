
package app;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VectoresTest {

    private int[] vectorNormal;
    private int[] vectorTam1;
    private int[] vectorVacio;
    private int[] vectorNull;

    @BeforeEach
    public void setUp() {
        vectorNormal = new int[]{3, 1, 4, 2, 5}; 
        vectorTam1 = new int[]{7};
        vectorVacio = new int[0];           
        vectorNull = null;
    }

    @Test
    public void testMaxValueNormal() {
        int resultado = Vectores.maxValue(vectorNormal);
        assertEquals(5, resultado);
    }

    @Test
    public void testMaxValueTam1() {
        int resultado = Vectores.maxValue(vectorTam1);
        assertEquals(7, resultado);
    }

    @Test
    public void testMaxValueVacio() {
        try {
            Vectores.maxValue(vectorVacio);
            fail("Se esperaba una excepción al usar vector vacío");
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testMaxValueNull() {
        try {
            Vectores.maxValue(vectorNull);
            fail("Se esperaba una excepción al usar vector null");
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testMinValueNormal() {
        int resultado = Vectores.minValue(vectorNormal);
        assertEquals(1, resultado);
    }

    @Test
    public void testMinValueTam1() {
        int resultado = Vectores.minValue(vectorTam1);
        assertEquals(7, resultado);
    }

    @Test
    public void testMinValueVacio() {
        try {
            Vectores.minValue(vectorVacio);
            fail("Se esperaba una excepción al usar vector vacío");
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testMinValueNull() {
        try {
            Vectores.minValue(vectorNull);
            fail("Se esperaba una excepción al usar vector null");
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testChangeValuesCorrecto() {//{3, 1, 4, 2, 5}; ->{3, 1, 4, 2, 5}; 
        boolean resultado = Vectores.changeValues(vectorNormal, 1, 5);//False
        assertTrue(resultado);
        assertEquals(5, vectorNormal[0]);
        assertEquals(3, vectorNormal[4]);
    }

    @Test
    public void testChangeValuesIndicesIguales() {//{3, 1, 4, 2, 5}; ->{3, 1, 4, 2, 5}; 
        boolean resultado = Vectores.changeValues(vectorNormal, 3, 3);//{4,4,4,4,4}
        assertTrue(resultado);
        assertEquals(4, vectorNormal[2]);//assertArrayEquals
    }

    @Test
    public void testChangeValuesFueraDeRango() {
        boolean result1 = Vectores.changeValues(vectorNormal, 0, 2);
        boolean result2 = Vectores.changeValues(vectorNormal, 1, 6);
        boolean result3 = Vectores.changeValues(vectorNormal, -1, 2);
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
    }

    @Test
    public void testChangeValuesNull() {
        boolean resultado = Vectores.changeValues(vectorNull, 1, 2);
        assertFalse(resultado);
    }

    @Test
    public void testChangeValuesTam1() {
        boolean resultado = Vectores.changeValues(vectorTam1, 1, 1);
        assertTrue(resultado);
        assertEquals(7, vectorTam1[0]);
    }
}
