package ejem1.deportista;

import java.sql.SQLException;
import java.util.ArrayList;

import ejem1.deportista.entity.Deportista;
import ejem1.exceptions.ResourceNotFoundException;

public class Service {
    private Repository repo = new Repository();

    // Ejercicio 1
    public ArrayList<Deportista> findAll() {
        try {
            return repo.getAll();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error en BD");
        }
    }

    // Ejercicio 2
    public Deportista findOne(int id) {
        try {
            Deportista d = repo.getOne(id);
            if (d==null) {
                 throw new ResourceNotFoundException("No se ha encontrado ningun deportista con este ID");
            }
            return d;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error en BD");
        }
    }

}
