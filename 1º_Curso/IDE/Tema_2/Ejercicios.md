# Tema 2 – Ejercicios (Introducción a los IDE y VSCode)

### Ejercicios para practicar, preguntar si surgen dudas.

#### Indica paso a paso cómo haces las siguientes tareas, debes citar los pasos que hay que seguir:

1. **Ver dos partes de un mismo archivo al mismo tiempo.**
    - Abrimos el archivo en VSCode.
    - Hacemos clic derecho en la pestaña del archivo y seleccionamos "Split Right" o "Split Down".

2. **Si tengo en un archivo el valor 200 en tres sitios distintos, ¿cómo cambio por 201 usando múltiples cursores?**
    - Seleccionamos el primer valor 200.
    - Presionamos `Ctrl+D` para seleccionar el siguiente valor 200.
    - Repetimos hasta que todos los valores 200 estén seleccionados.
    - Escribimos 201 y se cambiarán todos los valores seleccionados de forma simultanea.

3. **Informar de una tarea pendiente (TODO) en la línea 13 de un archivo cuya descripción sea: “Mejorar el interfaz de usuario”. ¿Dónde puedes ver esa tarea pendiente?**
    - En la línea 13, escribimos `// TOD0: Mejorar el interfaz de usuario`.
    - Podemos ver todas las tareas pendientes en la extensión Todo tree en el sidebar de vs code.

4. **Duplicar la línea actual justo debajo (sin copiar/pegar).**
    - Colocamos el cursor en la línea que queremos duplicar.
    - Presionamos `Shift+Alt+Down Arrow` para duplicar la línea justo debajo.

5. **Escribir en 5 líneas a la vez `System.out.printf`.**
    - Selecciona las 5 líneas donde deseas escribir.
    - Presionamos `Shift+Alt+I` para insertar cursores en cada línea seleccionada.
    - Escribe `System.out.printf`.

6. **Escribir un `switch` mediante un snippet existente.**
    - Escribimos `switch` y seleccionamos el snippet que nos sugiere VSCode.

7. **Comentar una serie de líneas de código de forma automática.**
    - Seleccionamos las líneas de código que queremos comentar.
    - Presionamos `Ctrl+/` para comentar o descomentar las líneas seleccionadas.
    - También podemos usar `Ctrl+k+c` para comentar y `Ctrl+k+u` para descomentar.

8. **Cambiar el tema del VSCode.**
    - Abrimos la paleta de comandos con `Ctrl+Shift+P`.
    - Escribimos `Preferences: Color Theme` y selecciona el tema deseado.

9. **Renombrar una variable en todas sus apariciones. Indica dos formas de hacerlo de forma segura.**
    - Método 1: Seleccionamos la variable, presionamos `F2`, escribimos el nuevo nombre y presionamos `Enter`.
    - Método 2: Usamos `Ctrl+Shift+L` para seleccionar todas las apariciones y luego escribimos el nuevo nombre.

10. **Haz que la combinación de teclas para abrir archivo sea `CTRL+K, O`.**
     - Abrimos la paleta de comandos con `Ctrl+Shift+P`.
     - Escribimos `Preferences: Open Keyboard Shortcuts`.
     - Buscamos `workbench.action.files.openFile`.
     - Asignamos la combinación `Ctrl+K, O`.

11. **Cambiar la forma habitual de inserción de texto por sobreescritura.**
     - Presionamos `Insert` en el teclado para cambiar entre inserción y sobreescritura.

12. **Hacer que al abrir una comilla no ponga otra de cierre automáticamente.**
     - Vamos a `File > Preferences > Settings`.
     - Buscamos `editor.autoClosingQuotes` y seleccionamos `never`.

13. **Instalar una extensión que permita visualizar un PDF dentro del VSCode.**
     - Vamos al icono de extensiones en el sidebar
     - Buscamos `PDF Viewer` y la instalamos.

### Ejercicios para validar

#### Ejercicio 1

Realiza un snippet para declarar e instanciar automáticamente un Scanner. El nombre será `scn`.

```json
{
    "Declaración de scanner": {
        "scope": "java",
        "prefix": "scn",
        "body": [
            "Scanner scn = new Scanner(System.in);"
        ],
        "description": "Snippet para declarar un Scanner"
    }
}
```

Haz otro que tenga dos líneas y se denomine `msg`:
   - La primera mostrará un mensaje (con `println`). Debe haber un tabstop (parada) en el mensaje que originalmente será una cadena vacía (`""`).
   - La segunda tendrá la clásica petición de dato con la asignación de un `nextLine` (o `nextInt`) a una variable.

```json
{
    "Imprimir en la consola": {
		"scope": "java",
		"prefix": "msg",
		"body": [
			"System.out.println(\"$1\");",
			"int ${2:variable} = sc.nextInt();"
		],
		"description": "Solicitud de un dato y lo guarda en una variable"
	}
}
```

Realiza una plantilla de código (snippet) que plantee un menú con 4 opciones y
salir. Será similar a la que aparece al final del apartado do-while del tema de
Estructuras de control de programación. La salvedad es que es con 4 opciones.
Otras características:
 - En los println aparecerán solo los números (“1.-”, “2.-”,…) con un tabstop
después de cada número.
 - Se debe declarar la variable de selección de opción, y esta ir á con
placeholder para que si se cambia en algún sitio cambie en todos.
 - Parará en cada case del switch.
 - No te olvides del bucle de repetición que también depende de la variable
opción.
```json
{
    "Menu con 4 opciones": {
        "scope": "java",
        "prefix": "menu4",
        "body": [
            "int ${1:option};",
            "do {",
            "    System.out.println(\"1.- $2\");",
            "    System.out.println(\"2.- $3\");",
            "    System.out.println(\"3.- $4\");",
            "    System.out.println(\"4.- $5\");",
            "    System.out.println(\"5.- Exit\");",
            "    $1 = sc.nextInt();",
            "    switch($1) {",
            "        case 1:",
            "            break;",
            "        case 2:",
            "            break;",
            "        case 3:",
            "            break;",
            "        case 4:",
            "            break;",
            "        case 5:",
            "            System.out.println(\"Saliendo del programa\");",
            "            break;",
            "        default:",
            "            System.out.println(\"Opcion no valida\");",
            "    }",
            "} while($1 != 5);"
        ],
        "description": "Snippet para un menú con 4 opciones y salir"
    }
}
```
