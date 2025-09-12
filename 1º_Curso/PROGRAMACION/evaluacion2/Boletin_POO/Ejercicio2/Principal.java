package PROGRAMACION.evaluacion2.Boletin_POO.Ejercicio2;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un día: ");
        int dia = sc.nextInt();
        System.out.print("Introduce un mes: ");
        int mes = sc.nextInt();
        System.out.print("Introduce un año: ");
        int año = sc.nextInt();

        System.out.println();

        Fecha fecha = new Fecha(dia, mes, año);
        Fecha fecha2 = new Fecha();

        System.out.println(fecha.fechaFormateada(true));
        System.out.println(fecha.fechaFormateada(false));

        System.out.println();

        System.out.println(fecha2.fechaFormateada(true));
        System.out.println(fecha2.fechaFormateada(false));

        System.out.println();

        System.out.println("La diferencia es de " + Fecha.diferenciaFechas(fecha, fecha2) + " años.");

        sc.close();
    }
}
