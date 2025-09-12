# Ejercicio 5: Clase Ventas

## Instrucciones

### a) Creación de la Clase Ventas

Crea una clase denominada `Ventas` que como mínimo conste de los siguientes miembros (ninguno es estático):

- Un vector público de 12 posiciones de números enteros que representarán las ventas de cada mes del año.
- Un entero privado que representa el año. Con métodos `set` y `get`. El `set` comprueba que el año sea menor que el actual (busca cómo obtener el actual). Si es mayor o igual se guarda el año anterior.
- Un constructor que inicialice el vector con números aleatorios entre 0 y 999 (ambos incluidos) y el año con un parámetro.
- Un constructor sobrecargado con dos parámetros: el año y el array de tamaño 12 con el que inicializa el vector de ventas. Si no fuera de tamaño 12 lo crea automáticamente como en el otro constructor.
- Un método denominado `media` que devuelve la media de valores del vector.
- Un método denominado `grafica` que muestra en pantalla un gráfico de barras de forma que cada 100 unidades vendidas aparezca un nuevo bloque `#` aumentado a la barra de ese mes. Será algo así (fíjate que quede bien formateado):

```plaintext
Año 2021:
Mes 1 (10): #
Mes 2 (220): ###
Mes 3 (920): ##########
Mes 4 (170): ##
…
```

### b) Programa Principal

En el programa principal (en otra clase) se realizan las siguientes tareas:

>[!NOTE]
> Puede existir un archivo denominado `ventas.txt` que tenga en la primera línea un año y en la segunda 12 valores enteros separados por punto y coma (;). Si existe lo lee y con esos datos crea un objeto `Ventas` llamando al constructor de dos parámetros. Para saber si existe usa la función `File.exists(nombreArchivo)`.

- Si no existe, crea un objeto de la clase `Ventas` con el año anterior al actual (averigua cómo obtener el actual y réstale 1).
- A continuación, se muestra el gráfico de barras, luego se muestra la media con dos decimales.
- Antes de acabar, guarda los datos en un archivo denominado `ventasXXXX.txt`. La `XXXX` es el año, por ejemplo `ventas2024.txt`. Guardará el año en la primera línea y en la segunda los datos del vector separados por punto y comas (;).

### c) Modificación del Main

Modifica el `main` de forma que si se le pasa desde la línea de comando el nombre del archivo ya trabaje con dicho archivo en vez de `ventas.txt`. Por ejemplo, se podría hacer:

```bash
java Principal ventas2024.txt
```

>[!TIP]
> Mira el Apéndice III de los apuntes para más información.