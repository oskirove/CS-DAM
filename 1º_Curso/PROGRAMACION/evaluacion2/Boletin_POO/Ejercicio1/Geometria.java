/*
 Crea una clase denominada Geometria con las siguientes propiedades:

 – figura: Será booleana. Privada. Si esta propiedad tiene el valor true, el
 objeto estará representando un rectángulo. Por el contrario si tiene el valor
 false, representa un triángulo. Se desea que sea de solo lectura por lo que
 tiene get pero no set (solo se inicializa en el constructor como se ve más
 abajo).

 – altura, base: Ambas reales. Privadas con set y get. ¿Se te ocurre alguna
 comprobación interesante que hacer en el set?
 Tendrá los siguientes constructores:

 – Uno vacío (sin parámetros) que inicializa los campos a triángulo (figura a
 false) y tanto la base como la altura a 2.

 – Uno con parámetros base y altura a partir de los que inicializa un triángulo
 con dicha base y altura que se les pasa como parámetro.

 – Un tercero con tres parámetros para inicializar las tres propiedades.
 Y los siguientes métodos:

 – area: Función que devuelve el área de la figura ( base*altura en el
 rectángulo y base*altura/2 en el triángulo). Recuerda que debes usar la
 base y la altura del propio objeto, no tiene ningún parámetro.
 
 – perimetro: Función que devuelve el perímetro de la figura. Tampoco tiene
 parámetros. En el caso del triángulo supón que es triángulo rectángulo, por
 lo que los lados serán la base, la altura y la diagonal (hipotenusa) que
 calculas en el siguiente método.

 – diagonal: Función que devuelve el tamaño de la diagonal del rectángulo o la
 hipotenusa del triángulo rectángulo (se calcula igual en ambos casos,
 averigua cómo si no lo sabes).

 – tipo: Función que devuelve el string “triángulo” o “rectángulo” dependiendo
 de figura.

 En otra clase sitúa el programa principal (main) y crea dos objetos:
 • Uno que represente un rectángulo a partir del constructor con parámetros
 que tú decidas.

 • Otro un triángulo con el constructor vacío. Luego usa los set para darle los
 valores de base y altura que decida el usuario.
 Luego muestra claramente los datos de cada uno.
*/

package PROGRAMACION.evaluacion2.Boletin_POO.Ejercicio1;

public class Geometria {
    private boolean figura;
    private double altura;
    private double base;

    public Geometria() {
        this.figura = false;
        this.altura = 2;
        this.base = 2;
    }

    public Geometria(double base, double altura) {
        this.figura = false;
        this.altura = altura;
        this.base = base;
    }

    public Geometria(boolean figura, double base, double altura) {
        this.figura = figura;
        this.altura = altura;
        this.base = base;
    }

    public boolean isFigura() {
        return figura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        }
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        if (base > 0) {
            this.base = base;
        }
    }

    public double area() {
        if (figura) {
            return base * altura;
        } else {
            return (base * altura) / 2;
        }
    }

    public double perimetro() {
        if (figura) {
            return 2 * (base + altura);
        } else {
            return base + altura + diagonal();
        }
    }

    public double diagonal() {
        return Math.sqrt(base * base + altura * altura);
    }

    public String tipo() {
        return figura ? "rectángulo" : "triángulo";
    }

}
