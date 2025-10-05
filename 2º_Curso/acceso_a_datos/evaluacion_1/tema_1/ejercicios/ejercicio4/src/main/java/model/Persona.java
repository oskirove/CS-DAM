package model;

import java.io.Serializable;
import java.util.UUID;

public class Persona implements Serializable {
    private UUID userID;
    private String name;
    private int age;
    private UUID departmentID;

    public Persona(String name, int age, UUID departmentID) {
        this.userID = UUID.randomUUID();
        this.name = name;
        this.age = age;
        this.departmentID = departmentID;
    }

    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        if (name.length() < 2 || name.length() > 50) {
            throw new IllegalArgumentException("El nombre debe tener entre 2 y 50 caracteres.");
        }

        this.name = name;
    }

    public void setAge(int age) {

        if (age < 0 || age > 66) {
            throw new IllegalArgumentException("La edad no puede ser un entero negativo ni superar 66");
        }
        
        this.age = age;
    }

    public void setDepartmentID(UUID departmentID) {

        if (departmentID == null) {
            throw new IllegalArgumentException("El departamento no puede ser nulo.");
        }

        this.departmentID = departmentID;
    }

    public UUID getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public UUID getDepartmentID() {
        return departmentID;
    }

    @Override
    public String toString() {
        return "\033[1;32m\n" + name.toUpperCase() + " \033[0m\n" + "- ID: " + userID + "\n" + "- Edad: " + age + "\n" + "- departamento:"
                + departmentID + '\n';
    }
}