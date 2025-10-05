package model.lib;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.UUID;

import model.Depart;
import model.Persona;

public class GestorFicheros {

    private File rutaPersonas = new File("src/main/java/model/colecciones/personas.dat");
    private File rutaPersonasTemporal = new File("src/main/java/model/colecciones/personas_temporal.dat");
    private File rutaDepartamentos = new File("src/main/java/model/colecciones/departamentos.dat");

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

    public ArrayList<Persona> leerTrabajadores() throws ClassNotFoundException, IOException {
        ArrayList<Persona> trabajadores = new ArrayList<>();

        try (FileInputStream fin = new FileInputStream(rutaPersonas);
                ObjectInputStream in = new ObjectInputStream(fin)) {

            Persona p;

            while (true) {
                p = (Persona) in.readObject();
                trabajadores.add(p);
            }

        } catch (EOFException e) {

            System.out.println("\033[44mLectura finalizada\033[0m");
            System.out.println();
        }

        return trabajadores;
    }

    public ArrayList<Depart> leerDepartamentos() throws ClassNotFoundException, IOException {
        ArrayList<Depart> departamentos = new ArrayList<>();

        try (FileInputStream fin = new FileInputStream(rutaDepartamentos);
                ObjectInputStream in = new ObjectInputStream(fin)) {

            Depart d;

            while (true) {
                d = (Depart) in.readObject();
                departamentos.add(d);
            }

        } catch (EOFException e) {

            System.out.println("\033[44mLectura finalizada\033[0m");
            System.out.println();
        }

        return departamentos;
    }

    public String vincularIdDepartamentoConNombre(ArrayList<Depart> departamentos, UUID idBuscado) {
        for (Depart d : departamentos) {
            if (d.getDepartmentID().equals(idBuscado)) {
                return d.getName();
            }
        }
        return null;
    }

    public void eliminarTrabajadores(String nombre, ArrayList<Persona> trabajadores)
            throws ClassNotFoundException, IOException {

        for (int i = trabajadores.size() - 1; i >= 0; i--) {

            Persona p = trabajadores.get(i);
            
            if (p.getName().equalsIgnoreCase(nombre)) {
                trabajadores.remove(p);
            }
        }

        try (FileOutputStream fos = new FileOutputStream(rutaPersonasTemporal);
                ObjectOutputStream out = new ObjectOutputStream(fos)) {
            for (Persona p : trabajadores) {
                out.writeObject(p);
            }

            if (rutaPersonas.exists()) {
                rutaPersonas.delete();
            }

            rutaPersonasTemporal.renameTo(rutaPersonas);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}