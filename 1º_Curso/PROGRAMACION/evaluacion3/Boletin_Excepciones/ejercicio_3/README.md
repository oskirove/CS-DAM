# Ejercicio 3: Función robusta para pedir un número entero

>[!NOTE]
> Este ejercicio consiste en crear una función que permita solicitar un número entero al usuario dentro de un rango específico, asegurando robustez en su implementación.

## Requisitos de la función

1. **Parámetros de entrada**:
  - Un mensaje que se mostrará al usuario antes de solicitar el dato.
  - Un rango definido por un límite inferior y un límite superior.

2. **Validaciones iniciales**:
  - Si el rango es inválido (es decir, no hay al menos 2 valores entre el límite inferior y el superior), la función debe lanzar una excepción `IllegalArgumentException` utilizando `throw`.
  - Si la cadena del mensaje está vacía o es nula, también debe lanzarse la misma excepción.

3. **Comportamiento esperado**:
  - Si los parámetros son correctos, la función debe iniciar un bucle en el que:
    - Solicite un número entero al usuario.
    - Verifique si el número ingresado está dentro del rango.
    - Compruebe si el dato ingresado es un número válido utilizando `try/catch`.

4. **Manejo de errores**:
  - Si el dato no está en el rango o no es un número válido, se debe informar al usuario del error y volver a solicitar el dato.

>[!TIP]
> Considera crear una función similar para números reales y agrupar ambas en una librería que puedas instalar como un proyecto Maven. Esto te será útil para otros ejercicios, como el **Ejercicio 1**.

## Consejos adicionales

- Asegúrate de que la función sea reutilizable y esté bien documentada.
- Implementa pruebas para validar los diferentes casos de uso, incluyendo los errores esperados.