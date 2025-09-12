package dev.Geometria;

public class Punto {
    public double x;
    public double y;

    public Punto(){
        this(0, 0);
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return String.format("(%.1f, %.1f)", x, y);
    }
    
}
