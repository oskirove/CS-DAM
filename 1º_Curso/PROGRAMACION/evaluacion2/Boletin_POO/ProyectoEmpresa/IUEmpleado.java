package PROGRAMACION.evaluacion2.Boletin_POO.ProyectoEmpresa;

import java.util.Scanner;

public class IUEmpleado {
    public Empleado empleado;

    public IUEmpleado(Empleado datosEmpleado) {
        this.empleado = datosEmpleado;
    }

    public void pedir() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre del empleado: ");
        String nombre = sc.nextLine();
        empleado.setNombre(nombre);

        System.out.print("Introduce los apellidos del empleado: ");
        String apellidos = sc.nextLine();
        empleado.setApellidos(apellidos);

        System.out.print("Introduce el DNI del empleado: ");
        String dni = sc.nextLine();
        empleado.setDni(dni);

        System.out.print("Introduce la edad del empleado: ");
        int edad = sc.nextInt();
        empleado.setEdad(edad);

        System.out.print("Introduce el salario del empleado: ");
        double salario = sc.nextDouble();
        empleado.setSalario(salario);
    }

    public void mostrar() {

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        String simboloEuro = "€";

        switch (opcion) {
            case 1:
                System.out.println("Nombre: " + empleado.getNombre());
                break;
            case 2:
                System.out.println("Apellidos: " + empleado.getApellidos());
                break;
            case 3:
                System.out.println("Edad: " + empleado.getEdad());
                break;
            case 4:
                System.out.println("DNI: " + empleado.getDni());
                break;
            case 5:
                System.out.printf("Salario: %.2f%s%n", empleado.getSalario(), simboloEuro);
                System.out.printf("La parte que se lleva Hacienda es de %.2f%s%n",
                        empleado.Hacienda(empleado.getSalario()), simboloEuro);
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        sc.close();
    }

    public void mostrar(int opcion) {

        String simboloEuro = "€";

        switch (opcion) {
            case 1:
                System.out.println("Nombre: " + empleado.getNombre());
                break;
            case 2:
                System.out.println("Apellidos: " + empleado.getApellidos());
                break;
            case 3:
                System.out.println("Edad: " + empleado.getEdad());
                break;
            case 4:
                System.out.println("DNI: " + empleado.getDni());
                break;
            case 5:
                System.out.printf("Salario: %.2f%s%n", empleado.getSalario(), simboloEuro);
                System.out.printf("La parte que se lleva Hacienda es de %.2f%s%n",
                        empleado.Hacienda(empleado.getSalario()), simboloEuro);
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }
}
