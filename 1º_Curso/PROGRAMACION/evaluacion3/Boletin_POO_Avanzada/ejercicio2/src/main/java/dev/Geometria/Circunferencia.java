package dev.Geometria;

import dev.interfaz.Libreria;

public class Circunferencia extends Figura {
    private double radio;

    public void setRadio(double radio) {

        if (radio < 0) {
            throw new IllegalArgumentException("Error: El radio no puede ser negativo: ");
        }

        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public Circunferencia() {
        this("Circunferencia", new Punto(0,0), 1);
    }

    public Circunferencia(String nombre, Punto centro, double radio) {
        super(centro, nombre);
        this.radio = radio;
    }

    @Override
    public void pedirDatos() {
        super.pedirDatos();

        double radio = Libreria.pedirReal("Introduce el radio: ");
        setRadio(radio);
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.printf("Radio: %.2f%n", getRadio());
    }
}