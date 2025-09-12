# Modelo de examen de programación 1ª Evaluación

## Normas

>[!NOTE]
> - El archivo debe tener en la parte superior como comentario el nombre, apellidos y DNI del alumno.
> - Podrá descontarse hasta 1 punto por mala identificación/claridad de código.
> - Se usará para la resolución de programas sólo elementos de Java vistos en la asignatura hasta el momento.
> - No se usará ninguna función que no sea de Java estándar (no se permiten librerías como Math u otras) salvo que se diga lo contrario. Tampoco se usarán códigos ANSI, ni las sentencias break ni continue para romper bucles (sí en switch).
> - No se permite acceder a código que no sea el realizado durante el examen. No se debe abrir ningún programa en Java, pseudocódigo ni ningún otro lenguaje de programación. Solo se permite tener abierto el Geany y la consola de ejecución.
> - Cuando se remate el examen se avisará al profesor para la entrega de los ejercicios resueltos y la subida de los mismos a la plataforma Moodle.
> - Si sabes hacer lo que se manda en las funciones pero sin funciones, hazlo en el programa principal (indícalo como comentario). Puntuará menos.

A continuación se plantean una serie de funciones que serán realizadas en el mismo archivo junto con un programa principal. El examen y archivo se llamarán `ExamenNombreApellido`. Guárdalo en el escritorio.

### 1. Función `bucles`

Realiza una función denominada `bucles` (sin parámetros ni valor devuelto) con 2 bucles `for` que hagan lo siguiente (hazlo con otro tipo de bucle si no controlas el `for`, contará menos):

- **Primer bucle:** Muestre los números impares entre 5 y 40 de forma decreciente y en una columna de forma que las unidades queden alineadas mediante formateo con `print` sea el número de una o dos cifras.
- **Segundo bucle:** Multiplique los números pares entre 1 y 10. Muestra el resultado fuera del bucle.

### 2. Función `calculos`

Realiza una función (nombre: `calculos`) que se le pasen dos parámetros enteros y devuelva:

- El primero elevado al segundo si el segundo es positivo (recuerda que no puedes usar `Math.pow`).
- El resto de dividir el primero entre el valor absoluto del segundo si el segundo es negativo.
- En otro caso, un número aleatorio entre 10 y el primer parámetro usando `Math.random()` (en este caso, si el primero fuera menor que 10 devuelve un aleatorio entre 10 y 20).

Comenta adecuadamente para javadoc la función anterior.

### 3. Función `mediasOSumas`

Haz una función llamada `mediasOSumas` que pida números reales al usuario y calcule la media o la suma de los mismos. Tendrá un parámetro entero que indique la cantidad de números a pedir y otro booleano que si está a `true` hace que la función devuelva la media y si está a `false` la función devolverá la suma.

### 4. Función `piramide`

Función (nombre: `piramide`) que muestre por pantalla:

```
10 9 8 7 6 5 4 3 2 1
9 8 7 6 5 4 3 2 1
8 7 6 5 4 3 2 1
7 6 5 4 3 2 1
6 5 4 3 2 1
5 4 3 2 1
4 3 2 1
3 2 1
2 1
1
```

Se usarán como máximo dos sentencias de escritura en pantalla `print`, `printf` o `println`. No se permite el uso de ningún carácter de escape (`'\n'`, `'\t'`, ...). No tiene parámetros. No devuelve nada.

### 5. Programa principal

El programa principal consta de un menú con las siguientes opciones:

- **1. Bucles:** Llama a la función `bucles`.
- **2. Cálculos:** Pide dos números enteros y se los pasa a la función `calculos`. Muestra el resultado.
- **3. Media:** Llama a la función `mediasOSumas` calculando la media. Muestra el resultado con 3 decimales.
- **4. Pirámide:** Llama a la función `piramide`.
- **5. Salir:** El programa no finaliza mientras no se seleccione esta opción del menú.

Debe hacerse con solo un bucle, un `switch`, sentencias de entrada y salida y llamadas a las funciones indicadas. Si se escoge un número no válido informa de ello y vuelve a mostrar el menú.

Si no has hecho alguna función haz al menos su cabecera y llámala desde el menú; así no se descontará nada.