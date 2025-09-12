import java.io.FileReader;
import java.io.IOException;

public class ejercicio2 {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("2º_Curso/acceso_a_datos/evaluacion_1/tema_1/ejercicio2/prueba.txt")) {

            char buffer[] = new char[50];
            int i;
            while ((i = fr.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, i));
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("error: " + e);
        }
    }
}