package PROGRAMACION.evaluacion2.IntroArrays.IntroArrays3;

public class Ejercicio {

    public static void main(String[] args) {

        String var = "Jar-Jar is the Big Boss";

        // Muestra la longitud de la cadena.
        System.out.println("Apartado A");
        System.out.println(var.length());
        System.out.println();

        // Muestra el primer carácter, el último y comprueba lo que pasa al acceder al carácter de la posición 100.
        System.out.println("Apartado B");

        System.out.println("Primer caracter: " + var.charAt(0)); // primer caracter.
        System.out.println("Último caracter: " + var.charAt(var.length() -1)); // Último caracter.
        // Con el caracter 100 se excede del tamaño del vector (Index 100 out of bounds for length 23).
        System.out.println();

        // Crea una segunda cadena a partir de la primera pasándola a mayúsculas y observa el resultado de equals y equalsIgnoreCase.
        System.out.println("Apartado C");

        System.out.println(var.toUpperCase());
        System.out.println(var.equals(var.toUpperCase())); // Da false por que la cadena no es la misma, es otra diferente.
        System.out.println(var.equalsIgnoreCase(var.toUpperCase())); // Da true por que la cadena es la misma, solo que una en mayúsculas y la otra en minúsculas, es decir ignora si son mayusculas o minusculas.
        System.out.println();

        // Muestra la cadena en minúsculas.
        System.out.println("Apartado D");

        System.out.println(var.toLowerCase());
        System.out.println();

        // Comprueba si la cadena acaba por “Boss” y por “Jar”.
        System.out.println("Apartado E");

        System.out.println(var.endsWith("Boss") && var.endsWith("Jar"));
        System.out.println();

        // Muestra la posición de la primera y la última vez que aparece la palabra “Jar”.
        System.out.println("Apartado F");

        System.out.println("Posición de la última aparición: " + var.lastIndexOf("Jar") + " | " + "Posición de la primera aparicion: " + var.indexOf("Jar"));
        System.out.println();

        // Crea otra variable String a partir del fragmento de la cadena anterior que empieza en la posición 7 y acaba en la 14 (ambos incluidos).
        System.out.println("Apartado G");

        String var2 = var.substring(7, 15);
        System.out.println(var2);
        System.out.println();

        // Quita los espacios de los extremos de la anterior cadena creada y muéstrala.
        System.out.println("Apartado H");

        System.out.println(var2.strip());
        System.out.println();

        // Crea un array de Strings con las palabras de la primera cadena (los separadores son el espacio y el guión).

        String var3[] = var.split(" |-");

        // Muestra cada palabra del array anterior en una linea ocupando 3 caracteres (cortala si es mayor). Esto no lo hagas con substring si no jugando con el formateo de printf.
        System.out.println("Apartado J");

        for (String i : var3) {
            System.out.printf("%.3s\n", i);
        }
        System.out.println();
    }
}
