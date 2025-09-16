import java.io.FileWriter;
import java.io.IOException;

public class ejercicio {

    public static void main(String[] args) {

        String cadena = "Hola mundo";

        try (FileWriter fw = new FileWriter("texto.txt", true)) {
            for (int i = 0; i < cadena.length(); i++) {
                fw.write(cadena.charAt(i));
            }
        } catch (IOException e) {

        }
    }
    
}
