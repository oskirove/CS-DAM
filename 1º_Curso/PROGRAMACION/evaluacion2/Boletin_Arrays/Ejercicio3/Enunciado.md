# Ejercicio 3: Adaptación a ArrayList

## Instrucciones

Repite el primer ejercicio adaptándolo a un `ArrayList<Integer>`. 

### Requisitos

1. **Colección de 10 elementos**: 
    - Prueba el programa principal con una colección de 10 elementos.

2. **Función de eliminación**:
    - Añade una función que reciba un valor como parámetro.
    - La función debe eliminar de la colección todos los elementos mayores que dicho parámetro.

### Ejemplo de Uso

```java
ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
eliminarMayoresQue(lista, 5);
// Resultado esperado: [1, 2, 3, 4, 5]
```

### Notas

- Asegúrate de manejar correctamente los casos en los que no haya elementos mayores que el parámetro.
- Considera el uso de iteradores para evitar `ConcurrentModificationException`.

### Recursos Adicionales

- [Documentación de ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- [Uso de Iteradores en Java](https://docs.oracle.com/javase/tutorial/collections/interfaces/iterator.html)
