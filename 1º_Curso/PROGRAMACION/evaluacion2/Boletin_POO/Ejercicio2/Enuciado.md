## Ejercicio 2

Se desea crear una clase que permita gestionar fechas de forma cómoda. Se establece la siguiente definición de la clase `Fecha`:

### Atributos
- `día`, `mes` y `año`: Son enteros y privados.
    - **Nota:** Si se introduce un día fuera del rango 1-31, se guardará 1. Si se introduce un mes fuera del rango 1-12, se guardará 1. No es necesario comprobar el mes para el número de días ni si el año es bisiesto.

### Constructores
- **Constructor vacío:** Inicializa todo a valores coherentes con una fecha (la que quieras).
- **Constructor sobrecargado:** Inicializa las tres propiedades a los parámetros.

### Métodos
- `fechaFormateada`: Método que devuelve la fecha en formato cadena. Dispone de un parámetro booleano que si está a `true` devuelve la fecha en formato numérico `día/mes/año` y si está a `false` lo hace en modo texto para el mes (por ejemplo `1 de diciembre de 1999`).
- `diferenciaFechas`: Función estática a la cual se le pasan dos objetos tipo `Fecha` como parámetros y devuelve solo la diferencia de años entre ambas fechas (int).

### Programa Principal
El programa principal (que no estará en la clase `Fecha`) pedirá dos fechas al usuario que guardará en sendos objetos. Mostrará las fechas en formato corto y largo y calculará la diferencia de años llamando a `diferenciaFechas`.

> [!NOTE]
> **Opcional:** Modifica `diferenciaFechas` para que calcule los días que van de una a otra. Se debe tener en cuenta meses de 30, 31, 28 y 29 días.