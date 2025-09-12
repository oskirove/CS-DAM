package PROGRAMACION.evaluacion2.Boletin_POO.Ejercicio1;

import java.util.Scanner;

public class GeometriaMain {
    public static void main(String[] args) {

        Geometria rectangulo = new Geometria(true, 5, 10);

        Geometria triangulo = new Geometria();

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la base del triángulo: ");
        double base = sc.nextDouble();
        System.out.print("Introduce la altura del triángulo: ");
        double altura = sc.nextDouble();

        triangulo.setBase(base);
        triangulo.setAltura(altura);

        System.out.printf("La base del rectangulo es %.2f%n", rectangulo.getBase());
        System.out.printf("La base del triangulo es %.2f%n", triangulo.getBase());
        System.out.printf("La altura del rectangulo es %.2f%n", rectangulo.getAltura());
        System.out.printf("La altura del triangulo es %.2f%n", triangulo.getAltura());
        System.out.printf("El area del triangulo es %.2f%n", triangulo.area());

        sc.close();
    }

}
