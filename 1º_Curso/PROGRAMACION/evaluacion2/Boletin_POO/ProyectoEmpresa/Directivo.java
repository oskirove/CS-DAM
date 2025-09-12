package PROGRAMACION.evaluacion2.Boletin_POO.ProyectoEmpresa;

public class Directivo {
    private String nombre;
    private String apellidos;
    private int edad;
    private String dni;
    private String departamento;
    private double beneficio;

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

    public String getDepartamento() {
        return "\"" + departamento + "\"";
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento.toUpperCase();
    }
    
    public double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(double beneficio) {
        if (beneficio > 100 || beneficio < 0) {
            this.beneficio = 0;
        } else {
            this.beneficio = beneficio;
        }
    }

    public Directivo() {
        this.nombre = "";
        this.apellidos = "";
        this.dni = "";
        this.edad = 0;
        this.departamento = "";
        this.beneficio = 0;
    }

    public Directivo(String nombre, String apellidos, String dni, String departamento, int edad, double beneficio) {
        setNombre(nombre);
        setApellidos(apellidos);
        setDni(dni);
        setDepartamento(departamento);
        setEdad(edad);
        setBeneficio(beneficio);
    }

    public double gananciaDirectivo(double beneficioEmpresa) {

        double ganancia = (getBeneficio()/100) * beneficioEmpresa;

        return ganancia;
    }
}