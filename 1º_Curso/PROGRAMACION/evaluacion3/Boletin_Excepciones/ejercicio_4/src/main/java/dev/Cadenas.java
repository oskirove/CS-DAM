package dev;

import java.util.Scanner;

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

       
            if (inicio > cadena.length()) {
                throw new IllegalArgumentException(
                        "El indice de inicio es mayor que la longitud de la cadena.");
            }

            if (numCaracteres > cadena.length()) {
                throw new IllegalArgumentException(
                        "El número de caracteres es mayor que la longitud de la cadena.");
            }

            int largo = inicio + numCaracteres;

            for (int i = inicio; i < largo; i++) {
                System.out.print(cadena.charAt(i));
            }

            System.out.println();

     
    }

    /**
     * Muestra una cadena centrada en la terminal.
     * 
     * @param cadena palabra o frase que queremos centrar en la terminal.
     */
    public static void muestraCentrado(String cadena) {

        
            if (cadena.length() > 68) {
                throw new IllegalArgumentException("La cadena no puede tener mas de 68 caracteres.");
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
            } catch (IllegalArgumentException e) {
                System.out.println("Introduce una cadena de texto valida");
            }
        }

        return cadena;
    }
}
