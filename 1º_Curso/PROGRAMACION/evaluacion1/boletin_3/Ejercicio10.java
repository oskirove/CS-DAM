/*
 Realizar un método que permita hallar el área de un rectángulo o de un
 triángulo rectángulo a partir de la base, la altura y un parámetro booleano
 (denominado bandera, flag o interruptor) para decidir si se trata de un rectángulo o
 un triángulo. Es decir, si se pasa como parámetro true hace el cálculo del área de
 un rectángulo, si se pasa false calcula el del triángulo.
 Devuelve el área. Parámetros del método: base, altura y la bandera.

 En el main codificar un menú clásico con las siguientes opciones:
 • Area de un triángulo (base*altura/2)
 • Area de un rectángulo (base*altura)
 • Area de un cuadrado (lado*lado)
 • Area de un círculo (Pi*radio2 ) 
 • Salir
*/

package PROGRAMACION.evaluacion1.boletin_3;

import java.util.Scanner;

public class Ejercicio10 {

    /**
     * Calcula el área de un rectangulo o de un triangulo.
     * @param base base de la figura.
     * @param altura altura de la figura
     * @param trigger disparador para decidir si se trata de un rectangulo o un triangulo.
     * @return el area de la figura.
     */

    public static double calcularArea(double base, double altura, boolean trigger) {

        if (trigger == true) {

            double area = base * altura;
            return area;

        } else {
            double area = base * altura / 2;
            return area;
        }
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {

            System.out.println("Menú");
            System.out.println("-----------------");
            System.out.println("1. Area de un triángulo");
            System.out.println("2. Area de un rectángulo");
            System.out.println("3. Area de un cuadrado");
            System.out.println("4. Area de un círculo");
            System.out.println("0. Salir");
            System.out.println("-----------------");
            System.out.print("Introduce una opción: ");
            
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Introduce la base del triángulo: ");

                    double base = sc.nextDouble();
                    System.out.print("Introduce la altura del triángulo: ");
                    double altura = sc.nextDouble();

                    System.out.println("El área del triángulo es: " + calcularArea(base, altura, false));
                    break;
                case 2:
                    System.out.print("Introduce la base del rectángulo: ");
                    base = sc.nextDouble();
                    System.out.print("Introduce la altura del rectángulo: ");
                    altura = sc.nextDouble();

                    System.out.println("El área del rectángulo es: " + calcularArea(base, altura, true));

                    break;
                case 3:
                    System.out.print("Introduce el lado del cuadrado: ");
                    double lado = sc.nextDouble();

                    System.out.println("El área del rectángulo es: " + calcularArea(lado, lado, true));

                    break;
                case 4:
                    System.out.print("Introduce el radio del círculo: ");
                    double radio = sc.nextDouble();

                    double resultado = Math.PI * Ejercicio6.potencia(radio, 2);

                    System.out.println("El area del circulo es: " + resultado);
                    break;

                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    };
};
