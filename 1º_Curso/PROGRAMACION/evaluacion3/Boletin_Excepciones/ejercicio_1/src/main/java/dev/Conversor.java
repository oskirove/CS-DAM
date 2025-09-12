package dev;

public class Conversor {
    private static double LIBRAS_A_EUROS = 1.1955;
    private static double EUROS_A_LIBRAS = 0.8365;

    public static double librasAEuros(double libras){
        return libras * LIBRAS_A_EUROS;
    }

    public static double eurosALibras(double euros){
        return euros * EUROS_A_LIBRAS;
    }
}
