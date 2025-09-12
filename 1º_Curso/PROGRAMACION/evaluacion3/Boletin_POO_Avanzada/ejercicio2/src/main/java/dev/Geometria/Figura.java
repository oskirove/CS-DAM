package dev.Geometria;

import java.util.Scanner;

import dev.interfaz.InterfazUsuario;
import dev.interfaz.Libreria;

public class Figura implements InterfazUsuario {
    protected Punto origen;
    protected String nombre;

    public void setOrigen(Punto origen) {
        if (origen == null) {
            throw new IllegalArgumentException("Error: Debes introducir un origen ");
        }

        this.origen = origen;
    }

    public Punto getOrigen() {
        return origen;
    }

    public void setNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("Error: La figura debe tener un nombre");
        }

        this.nombre = nombre.trim().toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }

    public Figura() {
        this(new Punto(), "");
    }

    public Figura(Punto origen, String nombre) {
        this.origen = origen;
        setNombre(nombre);
    }

    @Override
    public void pedirDatos() {
        Scanner sc = new Scanner(System.in);

        boolean triggerName = false;

        while (!triggerName) {
            try {

                System.out.print("Introduce el nombre de la figura: ");
                String nombre = sc.nextLine();
                setNombre(nombre);

                triggerName = true;

            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println(e.getMessage());
                System.out.println();
            }
        }

        System.out.println("Introduce el origen de la figura");

        double x = Libreria.pedirReal("Introduce la coordenada x: ");

        double y = Libreria.pedirReal("Introduce la coordenada y: ");

        Punto origen = new Punto(x, y);
        setOrigen(origen);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Tipo: " + getClass().getSimpleName().toUpperCase());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Origen: " + getOrigen());
    }
}
