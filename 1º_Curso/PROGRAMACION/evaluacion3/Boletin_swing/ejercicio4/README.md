## Enunciado del Ejercicio

Crea una aplicación Swing (con `layout null`) que contenga:

- **Tres campos de texto** (`JTextField`) con sus etiquetas correspondientes:
  - **Nombre** (`txfNombre`)
  - **Edad** (`txfEdad`)
  - **Dirección** (`txfDir`)

- **Dos botones**:
  - **Guardar** (`btnGuardar`):  
    - Si los datos de los campos de texto son válidos (no hay cadenas vacías y en edad hay un número positivo o 0), los guarda en un archivo.
    - Si ocurre algún problema, se informará al usuario mediante `JOptionPane.showDialog()` con un icono adecuado.
  - **Cargar** (`btnCargar`):  
    - Si existe un archivo de datos, lo lee.
    - Si los campos de texto están vacíos, coloca ahí los datos leídos.
    - Si los campos ya contienen información, pregunta al usuario con `JOptionPane` si está seguro de querer sobrescribirlos.
    - Si no existe el archivo, informa al usuario con `JOptionPane` y no realiza ninguna otra acción.