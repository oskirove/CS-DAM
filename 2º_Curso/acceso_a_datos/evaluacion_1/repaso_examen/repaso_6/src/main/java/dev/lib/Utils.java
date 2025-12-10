package dev.lib;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utils {
    public void addEstudent(String name, int edad) {
        try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("repaso_6/src/main/java/dev/alumnos.dat", true))) {
            dataOut.writeUTF(name);
            dataOut.writeInt(edad);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showEstudents() throws IOException {
        boolean flag = true;
        try (DataInputStream dataIn = new DataInputStream(new FileInputStream("repaso_6/src/main/java/dev/alumnos.dat"))) {
            while (flag) {
                try {
                    System.out.println(dataIn.readUTF());
                    System.out.println(dataIn.readInt());
                } catch (EOFException e) {
                    flag = false;
                }
            }
        } catch (EOFException e) {
            e.printStackTrace();
        }
    }
}
