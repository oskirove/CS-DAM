import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio {
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter(
                (new FileWriter("2º_Curso/acceso_a_datos/evaluacion_1/tema_1/ejercicio6/archivo.txt", true)))) {
            pw.println("QUE PASA CHAVALES");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
