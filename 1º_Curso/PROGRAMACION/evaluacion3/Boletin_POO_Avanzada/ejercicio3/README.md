# 🧵 Clase `Cadena` (Simulación de String en Java)

Se desea simular una clase parecida a `String`, denominada **`Cadena`**, con ciertas restricciones y funcionalidades específicas.

## 📌 Restricciones

- Solo se permite el uso de:
  - Concatenaciones (`+`)
  - Métodos `charAt()` y `length()`
- No se puede utilizar `substring()`, `split()`, `toCharArray()`, `indexOf()`, etc.

---

## 🧠 Características

### 🔐 Atributo

- `private ArrayList<Character> cadena;`  
  Contendrá los caracteres de la cadena como colección.

### 🛠️ Setter

- `void setCadena(String texto)`  
  Establece el valor de la colección a partir de un `String`:
  - Elimina los espacios en los extremos (`trim()`).
  - Añade carácter por carácter a la colección (`ArrayList<Character>`).

---

## 🔁 Métodos sobrescritos

### `toString()`

Devuelve la colección de caracteres como una cadena legible (`String`).

### `equals(Object obj)`

Devuelve `true` si:

- 🔸 `obj` es de tipo `Cadena` y tiene los mismos caracteres en el mismo orden.
- 🔸 `obj` es de tipo `String` y tiene los mismos caracteres en el mismo orden.
- 🔸 `obj` es de tipo `char[]` y tiene los mismos caracteres en el mismo orden.

⚠️ Si `obj` es `null` o **no** es de tipo `Cadena`, `String` o `char[]`, lanza una excepción:

```java
throw new IllegalArgumentException("Tipo no compatible");
