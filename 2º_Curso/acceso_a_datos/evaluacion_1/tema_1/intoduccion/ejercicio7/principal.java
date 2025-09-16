import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class principal {
    public static void getWordInLines(String word) {
        try (Scanner sc = new Scanner(new File("2º_Curso/acceso_a_datos/evaluacion_1/tema_1/ejercicio7/archivo.txt"))) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains(word)) {
                    
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String word = "mundo";

        getWordInLines(word);
    }
}
