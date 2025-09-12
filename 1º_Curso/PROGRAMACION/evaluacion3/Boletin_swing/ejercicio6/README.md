## Ejercicio 6

Crea un formulario con:

- **2 cajas de texto**
- **1 etiqueta**
- **3 botones**: uno de suma, otro de división y otro de raíz cuadrada

**Funcionamiento:**

- Al pulsar un botón, realizará la operación correspondiente con los valores de las cajas de texto.
  - La raíz cuadrada actúa solo sobre la primera caja.
- Mostrará el resultado en la etiqueta, anteponiendo un `=`.
- Si los valores no son numéricos, hay una división entre 0, o la raíz es de un número negativo, lo indicará en la `JLabel` de resultado en **color rojo** (NO uses `JOptionPane`).
- Los resultados válidos se mostrarán con **3 decimales** en **color negro**.
- Utiliza `FlowLayout`.

>[!NOTE]
> Si quieres evitar problemas con comas o puntos decimales, consulta el apéndice 3 del tema.