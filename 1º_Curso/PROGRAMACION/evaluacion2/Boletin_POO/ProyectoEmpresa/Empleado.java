package PROGRAMACION.evaluacion2.Boletin_POO.ProyectoEmpresa;

public class Empleado {

    private String nombre;
    private String apellidos;
    private int edad;
    private String dni;
    private double salario;
    private double irpf;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;

        if (salario < 6000) {
            irpf = 7.5;
        } else if (salario >= 6000 && salario < 30000) {
            irpf = 15;
        } else {
            irpf = 20;
        }
    }

    public double getIrpf() {
        return irpf;
    }

    public Empleado() {
        this.nombre = "";
        this.apellidos = "";
        this.dni = "";
        this.edad = 0;
        this.salario = 0;
        this.irpf = 7.5;
    }

    public Empleado(String nombre, String apellidos, String dni, int edad, double salario) {
        setNombre(nombre);
        setApellidos(apellidos);
        setDni(dni);
        setEdad(edad);
        setSalario(salario);
    }

    /**
     * Método que calcula el salario neto de un empleado
     * @param salario Salario del empleado
     * @return Salario neto del empleado
     */
    public double Hacienda(double salario) {
        double parteHacienda = 0;

        parteHacienda = salario * irpf/100;
        // if (salario < 6000) {
        // } else if (salario > 6000 && salario < 30000) {
        //     parteHacienda = salario * 0.15;
        // } else {
        //     parteHacienda = salario * 0.20;
        // }

        return parteHacienda;
    }
}