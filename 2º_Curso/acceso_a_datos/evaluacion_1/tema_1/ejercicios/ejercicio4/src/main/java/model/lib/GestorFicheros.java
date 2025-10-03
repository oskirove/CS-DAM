package model.lib;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Depart;
import model.Persona;

public class GestorFicheros {

    private String rutaPersonas = "src/main/java/model/colecciones/personas.dat";
    private String rutaDepartamentos = "src/main/java/model/colecciones/departamentos.dat";

    public void escribirPersonas(ArrayList<Persona> personas) {
        try (FileOutputStream fos = new FileOutputStream(rutaPersonas);
                ObjectOutputStream out = new ObjectOutputStream(fos)) {
                    for (Persona p : personas) {
                        out.writeObject(p);
                    }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void escribirDepartamentos(ArrayList<Depart> departamentos) {
        try (FileOutputStream fos = new FileOutputStream(rutaDepartamentos);
                ObjectOutputStream out = new ObjectOutputStream(fos)) {
                    for (Depart d : departamentos) {
                        out.writeObject(d);
                    }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}