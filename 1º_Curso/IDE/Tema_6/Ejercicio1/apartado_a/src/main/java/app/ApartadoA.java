/*
 a) Función año bisiesto. Realizar una función denominada bisiesto a la cual se le
 pasa un año como parámetro y devuelve true si dicho año es bisiesto y false en
 caso contrario.

 Un año es bisiesto cuando:
 • Es múltiplo de 4 (P. ej 1984)
 • Pero los múltiplos de 100 no lo son (Por ejemplo 1800)
 • Salvo si a su vez son múltiplos de 400 que caso sí lo son (p. ej. 2000)

 b) En el programa principal se hará un bucle que pida continuamente años al
 usuario hasta que introduzca el año 0 momento en el cual el programa termina. 
*/

package app;

public class ApartadoA {
    /**
     * Esta función determina si un año es bisiesto o no
     * @param año
     * @return
     */

    public static boolean añoBisiesto(int año){
        if (año % 4 == 0 && (año % 100 != 0 || año % 400 == 0)){
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        int año = 1;

        while (año != 0) {
            System.out.print("Introduce un año: ");
            año = sc.nextInt();
            System.out.println((añoBisiesto(año) == true) ? "El año introducido es bisiesto" : "El año introducido no es bisiesto");
        }
        sc.close();
    }
}
