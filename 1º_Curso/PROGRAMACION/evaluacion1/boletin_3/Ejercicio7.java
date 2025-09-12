/*
 a) Haz una función llamada loadFile a la cual se le pasa una cadena que
 representa el nombre de un archivo. Dicha función debe leer un archivo completo y
 devolverlo como string.
 Para probarla en el main usa el archivo del ejercicio 2.

 b) Realiza una función denominada appendFile a la que se le pasan dos cadenas, la
 primera es el nombre de un archivo y la segunda es un texto que debe añadir al
 final del archivo. Para ello primero lee el archivo, concatena la nueva cadenas y lo
 guarda de nuevo. Utiliza la función creada en (a) para la lectura.

 c) Realiza una función denominada appendFile2 que hace lo mismo que la realizada
 en (b) pero usando el método explicado en el Apéndice II de los apuntes
*/

package PROGRAMACION.evaluacion1.boletin_3;

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio7 {

    /**
     * Lee un archivo por completo.
     * 
     * @param nombreArchivo es el nombre del archivo que va a leer.
     * @throws Exception si no se puede acceder al archivo.
     */

    public static String loadFile(String nombreArchivo) throws Exception {
        Scanner lector = new Scanner(new FileReader(nombreArchivo));
        String contenido = "";

        while (lector.hasNextLine()) {
            contenido += lector.nextLine() + "\n";
        }

        lector.close();

        return contenido;
    };

    /**
     * Añade texto al final de un archivo.
     * 
     * @param nombreArchivo es el nombre del archivo al que se le añadirá texto.
     * @param textoAñadir  es el texto que se añadirá al final del archivo.
     * @throws Exception si no se puede acceder al archivo.
     */

    public static void appendFile(String nombreArchivo, String textoAñadir) throws Exception {
        String contenido = loadFile(nombreArchivo);

        PrintWriter f = new PrintWriter(nombreArchivo);

        String contenidoCompleto = contenido+textoAñadir;

        f.print(contenidoCompleto);
        f.close();
    };

    /**
     * Añade texto al final de un archivo.
     * 
     * @param nombreArchivo2 es el nombre del archivo al que se le añadirá texto.
     * @param textoAñadir2 es el texto que se añadirá al final del archivo.
     * @throws Exception si no se puede acceder al archivo.
     */

    public static void appendFile2(String nombreArchivo2, String textoAñadir2) throws Exception {

        PrintWriter f = new PrintWriter(new FileWriter(nombreArchivo2, true));

        f.println(textoAñadir2);
        f.close();
    };

    public static void main(String[] args) throws Exception {
        appendFile("Datos.txt", "Hola mundoooooo");
    };
};
