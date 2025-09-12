import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ejercicio {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File("2º_Curso/acceso_a_datos/evaluacion_1/tema_1/ejercicio5/archivo.txt"))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
