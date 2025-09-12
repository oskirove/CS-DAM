package app;

public class Potencia {

    public static double potencia(double baseFuncion, int exponente) {

        double resultado = 1;

        if (exponente < 0) {
            baseFuncion = 1 / baseFuncion;
            exponente = -exponente;
        }

        for (int i = 0; i < exponente; i++) {
            resultado *= baseFuncion;
        }

        return resultado;
    }
}
