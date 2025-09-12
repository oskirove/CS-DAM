# Superminitragaperras v2

Crea una nueva versión del **tragaperras v1** con las siguientes características:

- **Interfaz:**
  - 3 etiquetas con iconos.
  - 1 botón de juego.
  - 1 etiqueta que muestra el crédito actual.

- **Reglas del juego:**
  - El juego comienza con **10 €**.
  - Cada partida cuesta **1 €**.
  - Se generan **3 números aleatorios** entre 1 y 6, cada uno asociado a una imagen que se muestra en el formulario.
  - **Premios:**
    - 3 números iguales: **ganas 5 €**.
    - 2 números iguales: **ganas 1,5 €**.

- **Interfaz dinámica:**
  - El título del formulario será: `Superminitragaperras`.
  - Mediante un **timer**, el título irá apareciendo letra a letra cada **200 ms** (por ejemplo: S, Su, Sup, Supe, ...).

- **Mensajes al usuario:**
  - Se informará al usuario en una etiqueta si pierde o si hay premio.
  - En caso de premio, utilizando un **timer**, el color de la etiqueta parpadeará entre dos tonalidades a elegir hasta que se pulse de nuevo el botón de juego. El parpadeo será cada **400 ms** (puedes usar un timer diferente si lo prefieres).

---