package dev;

public class Geometria {
    private boolean figura;
    private double altura;
    private double base;

    public Geometria() {
        this.figura = false;
        this.altura = 2;
        this.base = 2;
    }

    public Geometria(double base, double altura) {
        this.figura = false;
        this.altura = altura;
        this.base = base;
    }

    public Geometria(boolean figura, double base, double altura) {
        this.figura = figura;
        this.altura = altura;
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {

        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor que 0");
        }

        this.altura = altura;

    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) { 
        if (base <= 0) {
            throw new IllegalArgumentException("La base debe ser mayor que 0");
        }

        if (base > 0) {
            this.base = base;
        }
    }

    public double area() {
        if (figura) {
            return base * altura;
        } else {
            return (base * altura) / 2;
        }
    }

    public double perimetro() {
        if (figura) {
            return 2 * (base + altura);
        } else {
            return base + altura + diagonal();
        }
    }

    public double diagonal() {
        return Math.sqrt(base * base + altura * altura);
    }

    public String tipo() {
        return figura ? "rectángulo" : "triángulo";
    }

}
