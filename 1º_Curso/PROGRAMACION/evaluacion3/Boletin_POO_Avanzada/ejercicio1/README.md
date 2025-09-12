# Ejercicio 1 - Boletín 6a (Excepciones)

Modifica el ejercicio 1 del boletín 6a (excepciones) siguiendo estas indicaciones:

## Cambios a realizar

1. **Creación de nuevas excepciones:**
  - Sustituye el uso de `IllegalArgumentException` por dos excepciones personalizadas.

2. **Excepción `StringTooLongException`:**
  - En el método `muestraCentrado`, si el parámetro de tipo `String` tiene más de **80 caracteres**, lanza una excepción personalizada llamada `StringTooLongException`.
  - Esta excepción debe heredar de `IllegalArgumentException`.
  - El mensaje de la excepción será: **"Cadena demasiado larga"**.
  - Pasa este mensaje al constructor de la clase base utilizando `super`.

3. **Excepción `StringOutOfBoundsException`:**
  - En el método `subCadena`, si los parámetros son inválidos, lanza una excepción personalizada llamada `StringOutOfBoundsException`.
  - Esta excepción debe heredar de `IndexOutOfBoundsException`.
  - Define un constructor que reciba un parámetro de tipo `String` y pásalo al constructor de la clase base.
  - Al lanzar la excepción desde el método, proporciona un mensaje que:
    - Indique que los parámetros son inválidos.
    - Informe del valor de los parámetros y del tamaño de la cadena.
