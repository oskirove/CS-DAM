> [!NOTE]
> Realiza los métodos estáticos que se citan a continuación. Realiza en el programa principal una prueba de los mismos con un vector de tamaño 10 (Ojo, el tamaño 10 es solo en el principal, las funciones han de ser genéricas y válidas para vectores de cualquier tamaño).

1. **Función que crea y devuelve un vector con `n` números enteros con valores aleatorios entre 1000 y 5000 ambos incluidos** (`n` es un parámetro de la función).
    ```java
    public static int[] crearVectorAleatorio(int n) {
        // Implementación de la función
    }
    ```

2. **Función a la que se le pasa un vector cualquiera de números enteros y muestra sus elementos por pantalla**. Debes usar un `for` mejorado mostrando elemento a elemento.
    ```java
    public static void mostrarVector(int[] vector) {
        // Implementación de la función
    }
    ```

3. **Función a la que se le pasa un vector cualquiera de enteros y devuelve el valor máximo que contiene**. Usa `for` clásico.
    ```java
    public static int valorMaximo(int[] vector) {
        // Implementación de la función
    }
    ```

4. **Función a la que se le pasa un vector cualquiera de enteros y devuelve el valor mínimo que contiene**. Usa `for` mejorado.
    ```java
    public static int valorMinimo(int[] vector) {
        // Implementación de la función
    }
    ```

5. **Función a la que se le pasa como parámetros un vector cualquiera de enteros y dos índices (son dos números enteros) e intercambia los datos que hay en las posiciones indicadas por los índices**. Si hay un error de rango devuelve `false`, si no devuelve `true`. Por ejemplo, si se le pasa `(v, 2, 5)` debe intercambiar los datos `v[2]` con `v[5]` siempre que existan dichas posiciones.
    ```java
    public static boolean intercambiarElementos(int[] vector, int indice1, int indice2) {
        // Implementación de la función
    }
    ```

> [!TIP]
> Asegúrate de probar cada función con diferentes tamaños de vectores y valores para verificar su correcto funcionamiento.