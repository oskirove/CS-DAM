package model.lib;

import java.util.Scanner;

public class Utils {

    private String COLOR_INICIO = "\033[1;34m";
    private String COLOR_ERROR_INICIO = "\033[41m";
    private String COLOR_CIERRE = "\033[0m";

    public String solicitarCadena(Scanner sc, String message) {

        while (true) {
            System.out.print(COLOR_INICIO + message + COLOR_CIERRE);
            String cadena = sc.nextLine().trim();

            if (cadena.isBlank()) {
                System.out.println();
                System.out.println(COLOR_ERROR_INICIO + "El campo no puede estar vacio." + COLOR_CIERRE);
                System.out.println();
                continue;
            }

            return cadena.toLowerCase();
        }
    }

    public int solicitarEntero(Scanner sc, String message) {

        while (true) {

            System.out.print(COLOR_INICIO + message + COLOR_CIERRE);
            String valorCadena = sc.nextLine().trim();

            if (valorCadena.isBlank()) {
                System.out.println(COLOR_ERROR_INICIO + "Error: El campo no puede estar vacio." + COLOR_CIERRE);
                continue;
            }

            try {
                int valor = Integer.parseInt(valorCadena);

                if (valor < 0) {
                    System.out.println();
                    System.out
                            .println(COLOR_ERROR_INICIO + "La edad debe ser un numero entero positivo." + COLOR_CIERRE);
                    System.out.println();
                    continue;
                }

                return valor;

            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println(
                        COLOR_ERROR_INICIO + "Error: Debes introducir un número entero válido." + COLOR_CIERRE);
                System.out.println();
                continue;
            }
        }
    }
}
