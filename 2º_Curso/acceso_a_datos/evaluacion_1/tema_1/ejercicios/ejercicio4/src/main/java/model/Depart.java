package model;

import java.io.Serializable;
import java.util.UUID;

public class Depart implements Serializable {
    private UUID departmentID;
    private String name;

    public Depart(String name) {
        this.departmentID = UUID.randomUUID();
        this.name = name;
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

    public UUID getDepartmentID() {
        return departmentID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Depart{id=" + departmentID + ", nombre='" + name + "'}";
    }
}