## Enunciado del Ejercicio

En un formulario se colocan **3 campos de texto** (`JTextField`) y un **botón** llamado **Color**.  
En dichos campos de texto se pueden introducir **números RGB** (0-255) en cada uno.  
Al pulsar el botón, se cambia el **color de fondo** del botón.

- Si al mismo tiempo que se produce el evento se está pulsando la tecla **CTRL**, en lugar del color de fondo se cambia el **color del texto** del botón.
- También cambiará si se pulsa **ENTER** en la **tercera caja de texto** (la referida al azul). En este caso, **no tendrá efecto el CTRL**.

Habrá otro **campo de texto** (de mayor tamaño) en el que se permite escribir el **path completo de una imagen**.  
Esta se cargará al pulsar **Enter** y se mostrará en otra **etiqueta** (`JLabel`).  
La trayectoria se le puede pasar directamente al constructor de `ImageIcon` sin necesidad de `getResource`.

> Introduce **ToolTips** en los botones y cajas de texto.  
> Usa **FlowLayout**.