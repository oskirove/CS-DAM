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
        final String VERDE = "\033[32m";
        final String CYAN = "\033[36m";
        final String CIERRE = "\033[0m";

        return String.format(
                "\n%s───────────────────────────────%s\n" +
                        "%sDepartamento%s\n" +
                        "%sID:%s %s\n" +
                        "%sNombre:%s %s\n" +
                        "%s───────────────────────────────%s\n",
                CYAN, CIERRE,
                VERDE, CIERRE,
                CYAN, CIERRE, departmentID,
                CYAN, CIERRE, name,
                CYAN, CIERRE);
    }
}