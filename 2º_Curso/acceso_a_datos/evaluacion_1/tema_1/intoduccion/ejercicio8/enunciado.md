7. Escribir un método que reciba dos parámetros: el primero será el nombre de un
archivo y el segundo una operación al realizar (para ordenar se puede usar la
clase Collections) siendo estas:
➢ Opción n: contar el número de líneas y palabras del archivo.
➢ Opción A: crear un nuevo archivo con las líneas del archivo inicial ordenadas
forma ascendente siendo esta ordenación sensible al caso.
➢ Opción D: crear un nuevo archivo con las líneas del archivo inicial ordenadas
forma descendente siendo esta ordenación sensible al caso.
➢ Opción a: crear un nuevo archivo con las líneas del archivo inicial ordenadas
forma ascendente siendo la ordenación no sensible al caso.
➢ Opción d: crear un nuevo archivo con las líneas del archivo inicial ordenadas
forma descendente siendo la ordenación no sensible al caso.


import java.io.*;
import java.util.*;

public class principal {
    public static void procesarArchivo(String nombreArchivo, char operacion) throws IOException {
        List<String> lineas = new ArrayList<>();
        int numLineas = 0;
        int numPalabras = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
                numLineas++;
                numPalabras += linea.trim().isEmpty() ? 0 : linea.trim().split("\\s+").length;
            }
        }

        switch (operacion) {
            case 'n':
                System.out.println("Número de líneas: " + numLineas);
                System.out.println("Número de palabras: " + numPalabras);
                break;
            case 'A':
                Collections.sort(lineas);
                escribirArchivo(nombreArchivo + "_asc.txt", lineas);
                break;
            case 'D':
                Collections.sort(lineas, Collections.reverseOrder());
                escribirArchivo(nombreArchivo + "_desc.txt", lineas);
                break;
            case 'a':
                lineas.sort(String.CASE_INSENSITIVE_ORDER);
                escribirArchivo(nombreArchivo + "_asc_ci.txt", lineas);
                break;
            case 'd':
                lineas.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
                escribirArchivo(nombreArchivo + "_desc_ci.txt", lineas);
                break;
            default:
                System.out.println("Operación no válida.");
        }
    }

    private static void escribirArchivo(String nombreArchivo, List<String> lineas) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java principal <nombreArchivo> <operacion>");
            return;
        }
        String nombreArchivo = args[0];
        char operacion = args[1].charAt(0);
        try {
            procesarArchivo(nombreArchivo, operacion);
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}