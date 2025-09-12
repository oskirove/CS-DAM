package app;

public class Geometria {
    public static double superficieCilindro(double radio, double altura) {
        double PI = 3.1416;
        double superficie = 2 * PI * radio * (radio + altura);
        return superficie;
    }
}
