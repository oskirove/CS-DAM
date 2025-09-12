# Enunciado Proyecto Empresa

## Clase `Empleado`

En una carpeta denominada `ProyectoEmpresa` crea una clase denominada `Empleado` con los campos privados:

- `nombre` (String)
- `apellidos` (String)
- `edad` (int)
- `dni` (String)
- `salario anual` (double)
- `irpf en %` (double)

> [!NOTE]
> El dato de % se usa para cálculos y para presentación al usuario, lógicamente en un `double` se guarda solo el número.

Debe incluir `set/get` para cada propiedad salvo para `IRPF` que sólo tendrá `get` pues cambiará solo cuando cambie el salario. Por tanto, `salario` debe ser una propiedad de forma que si es modificada, debe de cambiar el `IRPF`. Concretamente:

- Si el salario es menos de 6000 euros, el `IRPF` será del 7.5%
- Si está entre 6000 y 30000 euros, será del 15%
- Si es mayor que 30000 euros, el `IRPF` será del 20%

Debe haber dos constructores:

1. Uno vacío (sin parámetros) que inicialice los datos `String` a cadena vacía `""` y los numéricos a `0`.
2. Otro constructor que inicializa las propiedades a partir de parámetros. Usa los `set` para las inicializaciones. Piensa si hay alguna propiedad que no deba ir como parámetro.

Un último método devolverá la cantidad de dinero que se lleva hacienda (usando el `IRPF` y el salario).

## Clase `IUEmpleado`

En una clase aparte denominada `IUEmpleado` se hará el interface de usuario (IU) para esta clase. También se denomina vista. Esta clase dispondrá como propiedad pública única un objeto del tipo `Empleado` (denominada `empleado`) la cual se inicializa a través de un parámetro tipo `Empleado` en el constructor.

Además, `IUEmpleado` dispone de los siguientes métodos:

- `mostrar`: Muestra los campos del objeto `empleado` al usuario.
- `pedir`: Permite la introducción de los mismos por parte del usuario mediante teclado. Ninguno de estos dos métodos tiene parámetros ni devuelve nada.
- Sobrecarga del método `mostrar` de forma que se le pasa un `int` que representa a cada campo:
    - `1`: Nombre y Apellidos (los dos juntos)
    - `2`: Edad
    - `3`: DNI
    - `4`: Salario e IRPF (los dos juntos)
    - `5`: Lo que se lleva hacienda

Mostrará solo el dato indicado en el parámetro.

## Programa Principal

Para probarlo en el programa principal (en clase aparte):

1. Crea un objeto de esta clase.
2. Rellena con datos que se le pidan al usuario.
3. Luego muéstralos.
4. Muestra también lo que lleva hacienda.