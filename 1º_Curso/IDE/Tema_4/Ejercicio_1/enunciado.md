# Ejercicio 1

## Instrucciones

1. Sin usar VSCode, crea en un directorio denominado `raiz` un proyecto que tenga un paquete denominado `principal` en el que simplemente habrá una clase denominada `Principal` con un `main`.

2. En un subdirectorio de `principal` denominado `sumas` habrá una clase denominada `A` con la función no estática `f1` que devuelve la suma de los dos valores que se le pasan como parámetros.

3. En otro subdirectorio de `raiz` denominado `hola` crea una clase denominada `B` con la función estática `f2` que no devuelve nada, no tiene parámetros y simplemente muestra la palabra "HOLA" por pantalla.

4. En el `main` debes llamar a la función `f2`, luego pedir dos números y pasárselos a `f1` para finalmente mostrar lo que devuelve `f1`.

5. Debes compilarlo y ejecutarlo desde la consola.

## Resumen de estructura de packages y archivos

```plaintext
raiz
├───principal
│   └───Principal.java
│   └───sumas
│       └───A.java
└───hola
    └───B.java
```

>[!NOTE]
> Asegúrate de seguir la estructura de directorios y nombres de clases exactamente como se indica para evitar errores de compilación.

>[!TIP]
> Puedes usar el siguiente comando para compilar y ejecutar tu proyecto desde la consola:
> ```sh
> javac raiz/principal/Principal.java
> java -cp raiz principal.Principal
> ```