package dev.Geometria;

import dev.interfaz.Libreria;

public class Linea extends Figura{

    private Punto puntoFinal;

    public void setPuntoFinal(Punto puntoFinal) {
        this.puntoFinal = puntoFinal;
    }

    public Punto getPuntoFinal(){
        return puntoFinal;
    }
    
    public Linea(Punto origen, Punto puntoFinal) {
        super(origen, "linea");
        this.puntoFinal = puntoFinal;
    }
    
    public Linea() {
        this(new Punto(0, 0), new Punto(1, 1));
    }

    @Override
    public void pedirDatos(){
        super.pedirDatos();
        System.out.println("Intoduce el valor del punto final");
        double x = Libreria.pedirReal("Introduce el valor de x: ");
        double y = Libreria.pedirReal("Introduce el valor de y: ");

        puntoFinal = new Punto(x, y);
        setPuntoFinal(puntoFinal);
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Fin: " + getPuntoFinal());
    }
}
