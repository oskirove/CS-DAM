package PROGRAMACION.evaluacion2.Boletin_POO.ProyectoEmpresa;

import java.util.Scanner;

public class Empresa {
    private double ganancias;
    private Directivo directivo;
    private Empleado empleado1;
    private Empleado empleado2;
    public IUDirectivo IUDirectivo;
    public IUEmpleado IUEmpleado1;
    public IUEmpleado IUEmpleado2;


    public Empresa(Directivo directivo, Empleado empleado1, Empleado empleado2) {
        this.directivo = directivo;
        this.empleado1 = empleado1;
        this.empleado2 = empleado2;
        this.ganancias = 0;
        IUDirectivo = new IUDirectivo(directivo);
        IUEmpleado1 = new IUEmpleado(empleado1);
        IUEmpleado2 = new IUEmpleado(empleado2);
    }

    public Empresa(Directivo directivo, Empleado empleado1, Empleado empleado2, double ganancias) {
        this.directivo = directivo;
        this.empleado1 = empleado1;
        this.empleado2 = empleado2;
        this.ganancias = ganancias;
        IUDirectivo = new IUDirectivo(directivo);
        IUEmpleado1 = new IUEmpleado(empleado1);
        IUEmpleado2 = new IUEmpleado(empleado2);
    }

    public double getGanancias() {
        return ganancias;
    }

    public void setGanancias(double ganancias) {
        this.ganancias = ganancias;
    }

    public void verDatosEmpleados() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("--- Submenú: Ver datos empleados ---");
            System.out.println("1. Ver todos los datos de ambos empleados");
            System.out.println("2. Ver un dato de ambos empleados");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();

            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.println("Datos del Empleado 1:");
                    System.out.println("---------------------");
                    System.out.println("Nombre: " + empleado1.getNombre());
                    System.out.println("Apellidos: " + empleado1.getApellidos());
                    System.out.println("Edad: " + empleado1.getEdad());
                    System.out.println("DNI: " + empleado1.getDni());
                    System.out.printf("Salario: %.2f%n", empleado1.getSalario());
                    System.out.println();
                    System.out.println("Datos del Empleado 2:");
                    System.out.println("---------------------");
                    System.out.println("Nombre: " + empleado2.getNombre());
                    System.out.println("Apellidos: " + empleado2.getApellidos());
                    System.out.println("Edad: " + empleado2.getEdad());
                    System.out.println("DNI: " + empleado2.getDni());
                    System.out.printf("Salario: %.2f%n", empleado2.getSalario());
                    break;
                case 2:
                    do {
                        System.out.println("1. Ver nombres");
                        System.out.println("2. Ver apellidos");
                        System.out.println("3. Ver edades");
                        System.out.println("4. Ver documentos (DNI)");
                        System.out.println("5. Ver salarios");
                        System.out.println("6. Volver");
                        System.out.print("Selecciona una opción: ");
                        opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.println("Nombre empleado 1: " + empleado1.getNombre());
                                System.out.println("Nombre empleado 2: " + empleado2.getNombre());
                                break;

                            case 2:
                                System.out.println("Apellidos empleado 1: " + empleado1.getApellidos());
                                System.out.println("Apellidos empleado 2: " + empleado2.getApellidos());
                                break;
                            case 3:
                                System.out.println("Edad empleado 1: " + empleado1.getEdad());
                                System.out.println("Edad empleado 2: " + empleado2.getEdad());
                                break;
                            case 4:
                                System.out.println("DNI empleado 1: " + empleado1.getDni());
                                System.out.println("DNI empleado 2: " + empleado2.getDni());
                                break;
                            case 5:
                                System.out.println("Salario empleado 1: " + empleado1.getSalario());
                                System.out.println("Salario empleado 2: " + empleado2.getSalario());
                                break;
                            case 6:
                                System.out.println("Volviendo atrás...");
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    } while (opcion != 6);

                    break;
                case 3:
                    System.out.println("Saliendo del submenú...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    public void verDatosDirectivo() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("--- Submenú: Ver datos directivos ---");
            System.out.println("1. Ver todos los datos");
            System.out.println("2. Ver un dato específico");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();

            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.println("Datos del Directivo:");
                    System.out.println("---------------------");
                    System.out.println("Nombre: " + directivo.getNombre());
                    System.out.println("Apellidos: " + directivo.getApellidos());
                    System.out.println("DNI: " + directivo.getDni());
                    System.out.println("Departamento: " + directivo.getDni());
                    System.out.println("Edad: " + directivo.getEdad());
                    System.out.printf("Beneficio: %.2f%n", directivo.getBeneficio());
                    System.out.println();
                    break;
                case 2:
                    do {
                        System.out.println("1. Ver nombre");
                        System.out.println("2. Ver apellido");
                        System.out.println("3. Ver edad");
                        System.out.println("4. Ver DNI");
                        System.out.println("5. Ver Beneficio");
                        System.out.println("6. Ver Departamento");
                        System.out.println("7. Volver atrás");
                        System.out.print("Selecciona una opción: ");
                        opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.println("Nombre directivo: " + directivo.getNombre());
                                break;
                            case 2:
                                System.out.println("Apellidos directivo: " + directivo.getApellidos());
                                break;
                            case 3:
                                System.out.println("Edad directivo: " + directivo.getEdad());
                                break;
                            case 4:
                                System.out.println("DNI directivo: " + directivo.getDni());
                                break;
                            case 5:
                                System.out.println("Beneficio directivo: " + directivo.getBeneficio());
                                break;
                            case 6:
                                System.out.println("Departamento: " + directivo.getDepartamento());
                                break;
                            case 7:
                                System.out.println("Volviendo atrás...");
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    } while (opcion != 6);

                    break;
                case 3:
                    System.out.println("Saliendo del submenú...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    public void seleccionarEmpleado() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("--- Submenú: Modificar datos ---");
            System.out.println("1. Modificar datos del Empleado 1");
            System.out.println("2. Modificar datos del Empleado 2");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nuevo nombre del Empleado 1: ");
                    empleado1.setNombre(sc.next());
                    System.out.print("Nuevo apellido del Empleado 1: ");
                    empleado1.setApellidos(sc.next());
                    System.out.print("Nuevo dni del Empleado 1: ");
                    empleado1.setDni(sc.next());
                    System.out.print("Nueva edad del Empleado 1: ");
                    empleado1.setEdad(sc.nextInt());
                    System.out.print("Nuevo salario del Empleado 1: ");
                    empleado1.setSalario(sc.nextDouble());
                    System.out.println("Datos del Empleado 1 actualizados.");
                    break;
                case 2:
                    System.out.print("Nuevo nombre del Empleado 2: ");
                    empleado2.setNombre(sc.next());
                    System.out.print("Nuevo apellido del Empleado 2: ");
                    empleado2.setApellidos(sc.next());
                    System.out.print("Nuevo dni del Empleado 2: ");
                    empleado2.setDni(sc.next());
                    System.out.print("Nueva edad del Empleado 2: ");
                    empleado2.setEdad(sc.nextInt());
                    System.out.print("Nuevo salario del Empleado 2: ");
                    empleado2.setSalario(sc.nextDouble());
                    System.out.println("Datos del Empleado 2 actualizados.");
                    break;
                case 3:
                    System.out.println("Saliendo del submenú...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

    }

    public void modificarDatos() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("--- Submenú: Modificar datos ---");
            System.out.println("1. Modificar datos del directivo");
            System.out.println("2. Modificar datos de los empleados");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nuevo nombre del directivo: ");
                    directivo.setNombre(sc.next());
                    System.out.print("Nuevo apellidos del directivo: ");
                    directivo.setApellidos(sc.next());
                    System.out.print("Nuevo departamento del directivo: ");
                    directivo.setDepartamento(sc.next());
                    System.out.print("Nuevo DNI del directivo: ");
                    directivo.setDni(sc.next());
                    System.out.print("Nuevo beneficio del directivo: ");
                    directivo.setBeneficio(sc.nextDouble());
                    System.out.print("Nueva edad del directivo: ");
                    directivo.setEdad(sc.nextInt());
                    System.out.println("Datos del directivo actualizados.");
                    break;
                case 2:
                    seleccionarEmpleado();
                    break;
                case 3:
                    System.out.println("Saliendo del submenú...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    public void pagar(double salario1, double salario2, double ganancias) {

        double total = salario1 + salario2;
        double resto = ganancias - total;

        System.out.printf("Ganancias antes del pago: %.2f%n", ganancias);
        setGanancias(resto);
        System.out.println(getGanancias());
        System.out.printf("Ganancias despues del pago: %.2f%n", resto);
    }

    public void cobrar() {
        
    }
}
