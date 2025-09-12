> [!NOTE]
> Repite el ejercicio anterior pero adaptándolo a una matriz de tamaño `n` filas y `m` columnas que guarde caracteres (`char`) aleatorios entre `A` y `Z`. En el `main`, pruébalo con una tabla de `3x4` y luego una de `4x3`.

1. **Función que crea y devuelve una matriz de `n` filas y `m` columnas con caracteres aleatorios entre `A` y `Z`** (`n` y `m` son parámetros de la función).
    ```java
    public static char[][] crearMatrizAleatoria(int n, int m) {
        // Implementación de la función
    }
    ```

2. **Función que muestra la matriz con formato de tabla, con cada carácter de una fila separado por al menos dos espacios y con cabecera de número de fila y columna**.
    ```java
    public static void mostrarMatriz(char[][] matriz) {
        // Implementación de la función
    }
    ```

    Ejemplo:
    ```
      0  1  2  3
    0 D  R  A  Y
    1 J  O  P  C
    2 H  P  A  S
    ```

3. **Función que intercambia dos posiciones en la matriz, dadas por cuatro índices**. Si hay un error de rango devuelve `false`, si no devuelve `true`.
    ```java
    public static boolean intercambiarElementos(char[][] matriz, int fila1, int col1, int fila2, int col2) {
        // Implementación de la función
    }
    ```

> [!TIP]
> Asegúrate de probar cada función con diferentes tamaños de matrices y valores para verificar su correcto funcionamiento.