import java.io.FileReader;
import java.io.IOException;

public class ejercicio {
    public static void main(String[] args) {

        try (FileReader fr = new FileReader("2º_Curso/acceso_a_datos/evaluacion_1/tema_1/ejercicio4/archivo.txt");) {

            char buffer[] = new char[4];
            int i;
            int contador = 0;
            char caracter = 's'; 

            while ((i = fr.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, i));

                for (int j = 0; j < i; j++) {
                    if (buffer[j] == caracter) {
                        contador++;
                    }
                }
            }

            System.out.println();

            System.out.println("Tiene " + contador + " letras " + caracter);

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }
}
