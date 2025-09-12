package dev.Geometria;

import dev.interfaz.Libreria;

public class Poligono extends Figura {

    public Punto[] puntos;

    public Poligono() {
        this("triangulo", new Punto(0, 0), 3);

       // this.puntos = new Punto[3];

        puntos[0] = new Punto(0, 0);
        puntos[1] = new Punto(1, 1);
        puntos[2] = new Punto(1, 0);
    }

    public Poligono(String nombre, Punto centro, int cantidadPuntos) {
        this.nombre = nombre;//TODO super()
        this.origen = centro;
        this.puntos = new Punto[cantidadPuntos];

        for (int i = 0; i < cantidadPuntos; i++) {
            this.puntos[i] = new Punto(Math.random() * 10, Math.random() * 10);
        }
    }

    @Override
    public void pedirDatos() {
        super.pedirDatos();

        int cantidadPuntos = Libreria.pedirEntero("Introduce una cantidad de puntos: ");

        puntos = new Punto[cantidadPuntos];

        for (int i = 0; i < cantidadPuntos; i++) {
            puntos[i] = new Punto(Math.random() * 10, Math.random() * 10);
        }
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();

        System.out.println("Los puntos son: ");

        for (Punto row : puntos) {
            System.out.println(row);
        }
    }
}