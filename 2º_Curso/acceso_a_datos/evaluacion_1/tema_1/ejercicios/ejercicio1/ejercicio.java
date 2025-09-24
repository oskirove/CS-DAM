import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio {

    public static void main(String[] args) {
        File file = new File("2º_Curso/acceso_a_datos/evaluacion_1/tema_1/ejercicios/ejercicio1/fichero.txt");
        try (FileReader archivo = new FileReader(file)) {
            int[] frecuencia = new int[256];

            int caracter;

            while ((caracter = archivo.read()) != -1) {
                if (caracter >= 0 && caracter < 256) {
                    frecuencia[caracter]++;
                }
            }

            int maximaFrecuencia = 0;
            char masUsado = 0;

            for (int i = 0; i < frecuencia.length; i++) {
                if (frecuencia[i] > maximaFrecuencia) {
                    maximaFrecuencia = frecuencia[i];
                    masUsado = (char) i;
                }
            }

            System.out.println();
            System.out.println("El caracter más usado es {" + masUsado + "} apareciendo {" + maximaFrecuencia + "} veces.");
            System.out.println();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
