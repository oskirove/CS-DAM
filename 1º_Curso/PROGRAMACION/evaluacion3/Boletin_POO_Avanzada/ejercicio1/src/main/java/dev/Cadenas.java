package dev;

import java.util.Scanner;

import dev.exceptions.FueraDeLimites;
import dev.exceptions.StringTooLongException;

public class Cadenas {

    /**
     * Extrae e imprime una subcadena de la cadena dada comenzando en el índice
     * especificado
     * y abarcando el número de caracteres especificado.
     *
     * @param cadena        la cadena original de la cual se extrae la subcadena
     * @param inicio        el índice de inicio de la subcadena
     * @param numCaracteres el número de caracteres a incluir en la subcadena
     */

    public static void subCadena(String cadena, int inicio, int numCaracteres) {

        try {//quitar try's
            if (inicio > cadena.length()) {
                throw new FueraDeLimites(
                        "El indice de inicio es mayor que la longitud de la cadena.");
            }

            if (numCaracteres > cadena.length()) {
                throw new FueraDeLimites(
                        "El número de caracteres es mayor que la longitud de la cadena.");
            }

            int largo = inicio + numCaracteres;

            for (int i = inicio; i < largo; i++) {
                System.out.print(cadena.charAt(i));
            }

            System.out.println();

        } catch (FueraDeLimites e) {
            System.out.println(e.getMessage());
            System.out.println("El índice de inicio es: " + inicio);
            System.out.println("El número de caracteres es: " + numCaracteres);
            System.out.println("La longitud de la cadena es: " + cadena.length());
        }
    }

    /**
     * Muestra una cadena centrada en la terminal.
     * 
     * @param cadena palabra o frase que queremos centrar en la terminal.
     */
    public static void muestraCentrado(String cadena) {

        try {
            if (cadena.length() > 68) {
                throw new StringTooLongException("Cadena demasiado larga");
            }
            int operacion = 68 - (cadena.length() / 2);
            System.out.println();

            for (int i = 0; i <= operacion; i++) {
                System.out.print(" ");
            }
            System.out.print(cadena);

            for (int i = 0; i <= operacion; i++) {
                System.out.print(" ");
            }
            System.out.println();
        } catch (StringTooLongException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String solicitarCadena() {
        Scanner sc = new Scanner(System.in);

        boolean trigger = false;
        String cadena = "";

        while (!trigger) {
            try {

                System.out.print("Introduce una cadena: ");
                cadena = sc.nextLine();

                trigger = true;
            } catch (FueraDeLimites e) {
                System.out.println("Parámetros invalidos");
            }
        }

        return cadena;
    }
}
