# Programación DAM

Este repositorio contiene todos los ejercicios de la asignatura de Programación del ciclo formativo de Desarrollo de Aplicaciones Multiplataforma (DAM).
## Índice

1. [Contenido](#contenido)
2. [Básicos de Java](#básicos-de-java)
    - [Sintaxis básica](#sintaxis-básica)
    - [POO (Programación Orientada a Objetos)](#poo-programación-orientada-a-objetos)
    - [Manejo de excepciones](#manejo-de-excepciones)
    - [Colecciones](#colecciones)
    - [Flujo de control](#flujo-de-control)
    - [Entrada/Salida (I/O)](#entradasalida-io)
    - [Bibliotecas estándar](#bibliotecas-estándar)
    - [JDK y JRE](#jdk-y-jre)
    - [Herramientas de desarrollo](#herramientas-de-desarrollo)
3. [Ejemplos de Básicos de Java](#ejemplos-de-básicos-de-java)
    - [Estructuras básicas de control](#estructuras-básicas-de-control)
        - [`if`](#if)
        - [`while`](#while)
        - [`for`](#for)
        - [`do-while`](#do-while)
        - [`switch`](#switch)
    - [Operadores importantes](#operadores-importantes)
        - [Operadores aritméticos](#operadores-aritméticos)
        - [Operadores de comparación](#operadores-de-comparación)
        - [Operadores lógicos](#operadores-lógicos)
4. [Notas y Tips](#notas-y-tips)


## Contenido

- Ejercicios prácticos
- Proyectos
- Notas y tips


## Básicos de Java

- **Sintaxis básica**: Familiarízate con la sintaxis básica de Java, incluyendo la estructura de una clase, métodos, y el uso de variables y tipos de datos.
- **POO (Programación Orientada a Objetos)**: Java es un lenguaje orientado a objetos. Entiende los conceptos de clases, objetos, herencia, polimorfismo y encapsulamiento.
- **Manejo de excepciones**: Aprende a manejar errores y excepciones utilizando `try`, `catch`, `finally`, y las diferentes excepciones que Java proporciona.
- **Colecciones**: Conoce las colecciones de Java como `ArrayList`, `HashMap`, `HashSet`, y cómo utilizarlas.
- **Flujo de control**: Domina las estructuras de control de flujo como `if`, `else`, `switch`, `for`, `while`, y `do-while`.
- **Entrada/Salida (I/O)**: Aprende a manejar la entrada y salida de datos, tanto desde la consola como desde archivos.
- **Bibliotecas estándar**: Familiarízate con las bibliotecas estándar de Java, como `java.lang`, `java.util`, `java.io`, y `java.nio`.
- **JDK y JRE**: Entiende la diferencia entre el Java Development Kit (JDK) y el Java Runtime Environment (JRE).
- **Herramientas de desarrollo**: Utiliza herramientas como IDEs (Eclipse, IntelliJ IDEA, NetBeans) y sistemas de construcción (Maven, Gradle).

## Ejemplos de Básicos de Java
### Estructuras básicas de control

#### `if`

El `if` es una estructura de control que permite ejecutar un bloque de código si una condición es verdadera.

```java
int numero = 10;
if (numero > 0) {
    System.out.println("El número es positivo");
}
```

#### `while`

El `while` es un bucle que ejecuta un bloque de código mientras una condición sea verdadera.

```java
int i = 0;
while (i < 5) {
    System.out.println("i: " + i);
    i++;
}
```

#### `for`

El `for` es un bucle que se utiliza para iterar sobre un rango de valores.

```java
for (int i = 0; i < 5; i++) {
    System.out.println("i: " + i);
}
```

#### `do-while`

El `do-while` es un bucle que ejecuta un bloque de código al menos una vez y luego continúa mientras la condición sea verdadera.

```java
int i = 0;
do {
    System.out.println("i: " + i);
    i++;
} while (i < 5);
```

#### `switch`

El `switch` es una estructura de control que permite seleccionar una de varias opciones basadas en el valor de una expresión.

```java
int dia = 3;
switch (dia) {
    case 1:
        System.out.println("Lunes");
        break;
    case 2:
        System.out.println("Martes");
        break;
    case 3:
        System.out.println("Miércoles");
        break;
    default:
        System.out.println("Día no válido");
        break;
}
```

### Operadores importantes

#### Operadores aritméticos

Se utilizan para realizar operaciones matemáticas básicas.

- `+` (suma)
- `-` (resta)
- `*` (multiplicación)
- `/` (división)
- `%` (módulo)

```java
int a = 10;
int b = 5;
int suma = a + b; // 15
int resta = a - b; // 5
int multiplicacion = a * b; // 50
int division = a / b; // 2
int modulo = a % b; // 0
```

#### Operadores de comparación

Se utilizan para comparar dos valores.

- `==` (igual a)
- `!=` (diferente de)
- `>` (mayor que)
- `<` (menor que)
- `>=` (mayor o igual que)
- `<=` (menor o igual que)

```java
int a = 10;
int b = 5;
boolean esIgual = (a == b); // false
boolean esMayor = (a > b); // true
```

#### Operadores lógicos

Se utilizan para combinar múltiples condiciones.

- `&&` (AND lógico)
- `||` (OR lógico)
- `!` (NOT lógico)

```java
boolean condicion1 = true;
boolean condicion2 = false;
boolean resultadoAND = condicion1 && condicion2; // false
boolean resultadoOR = condicion1 || condicion2; // true
boolean resultadoNOT = !condicion1; // false
```
### Sintaxis básica

```java
// Ejemplo de una clase en Java
public class HolaMundo {
    public static void main(String[] args) {
        System.out.println("¡Hola, Mundo!");
    }
}
```
Este ejemplo muestra la estructura básica de una clase en Java y cómo imprimir un mensaje en la consola. Es útil para entender la sintaxis básica de Java.

### POO (Programación Orientada a Objetos)

```java
// Ejemplo de clases y objetos
class Animal {
    String nombre;

    void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }
}

public class Perro extends Animal {
    void hacerSonido() {
        System.out.println("El perro ladra");
    }

    public static void main(String[] args) {
        Perro miPerro = new Perro();
        miPerro.nombre = "Firulais";
        miPerro.hacerSonido();
    }
}
```
Este ejemplo ilustra los conceptos de clases y herencia en Java. Es útil para entender cómo se crean y utilizan objetos y cómo funciona la herencia.

### Manejo de excepciones

```java
// Ejemplo de manejo de excepciones
public class ManejoExcepciones {
    public static void main(String[] args) {
        try {
            int division = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero");
        } finally {
            System.out.println("Bloque finally ejecutado");
        }
    }
}
```
Este ejemplo muestra cómo manejar excepciones en Java utilizando `try`, `catch` y `finally`. Es útil para aprender a gestionar errores en el código.

### Colecciones

```java
// Ejemplo de uso de ArrayList
import java.util.ArrayList;

public class EjemploArrayList {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");

        for (String elemento : lista) {
            System.out.println(elemento);
        }
    }
}
```
Este ejemplo demuestra cómo utilizar la clase `ArrayList` para almacenar y manipular una lista de elementos. Es útil para trabajar con colecciones de datos.

### Flujo de control

```java
// Ejemplo de estructuras de control de flujo
public class EjemploFlujoControl {
    public static void main(String[] args) {
        int numero = 5;

        if (numero > 0) {
            System.out.println("El número es positivo");
        } else {
            System.out.println("El número es negativo o cero");
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("i: " + i);
        }
    }
}
```
Este ejemplo muestra cómo utilizar estructuras de control de flujo como `if` y `for`. Es útil para controlar el flujo de ejecución del programa.

### Entrada/Salida (I/O)

```java
// Ejemplo de lectura y escritura de archivos
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EjemploIO {
    public static void main(String[] args) {
        // Escribir en un archivo
        try (FileWriter writer = new FileWriter("archivo.txt")) {
            writer.write("Hola, archivo!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leer de un archivo
        try (BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
Este ejemplo muestra cómo leer y escribir archivos en Java. Es útil para manejar la entrada y salida de datos desde y hacia archivos.

### Bibliotecas estándar

```java
// Ejemplo de uso de bibliotecas estándar
import java.util.ArrayList;
import java.util.Collections;

public class EjemploBibliotecas {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(3);
        numeros.add(1);
        numeros.add(2);

        Collections.sort(numeros);

        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}
```
Este ejemplo muestra cómo utilizar las bibliotecas estándar de Java, como `ArrayList` y `Collections`. Es útil para realizar operaciones comunes con colecciones de datos.

### JDK y JRE

```markdown
**JDK (Java Development Kit)**: Incluye el compilador de Java, herramientas de desarrollo y el JRE. Es necesario para desarrollar aplicaciones Java.

**JRE (Java Runtime Environment)**: Incluye la JVM (Java Virtual Machine) y las bibliotecas necesarias para ejecutar aplicaciones Java. No incluye herramientas de desarrollo.
```

### Herramientas de desarrollo

```markdown
**IDEs (Entornos de Desarrollo Integrados)**:
- **Eclipse**: Un IDE popular y extensible para Java.
- **IntelliJ IDEA**: Un IDE potente con muchas características avanzadas.
- **NetBeans**: Un IDE fácil de usar con soporte para múltiples lenguajes.

**Sistemas de construcción**:
- **Maven**: Una herramienta de gestión y construcción de proyectos basada en POM (Project Object Model).
- **Gradle**: Una herramienta de construcción flexible que soporta múltiples lenguajes y plataformas.
```
## Notas y Tips

> [!TIP]
> Mantén tu código organizado y bien documentado. Una buena organización facilita la lectura y el mantenimiento del código a largo plazo.

> [!TIP]
> Utiliza control de versiones (Git) para gestionar tus cambios y colaborar con otros. El control de versiones te permite llevar un historial de cambios y revertir a versiones anteriores si es necesario.

> [!IMPORTANT]
> La programación es un campo en constante evolución. Mantente al día con las nuevas tecnologías y metodologías. Participa en comunidades, asiste a conferencias y realiza cursos en línea para seguir aprendiendo.

> [!NOTE]
> Aprende a usar herramientas de depuración para identificar y solucionar errores en tu código. La depuración eficiente puede ahorrarte mucho tiempo y esfuerzo en el desarrollo.

> [!TIP]
> Trabaja en equipo y comparte conocimientos con tus compañeros. La colaboración y el intercambio de ideas enriquecen el aprendizaje y mejoran la calidad del trabajo.

> [!NOTE]
> Sigue las buenas prácticas de programación, como el uso de nombres descriptivos para variables y funciones. Esto mejora la legibilidad y comprensión del código por parte de otros desarrolladores.

