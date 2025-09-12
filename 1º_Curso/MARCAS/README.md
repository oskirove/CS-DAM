# Lenguajes de Marcas y Sistemas de Información

## Índice

1. [Introducción](#introducción)
2. [HTML](#html)
    - [Estructura Básica](#estructura-básica)
    - [Etiquetas Comunes](#etiquetas-comunes)
    - [Atributos Globales](#atributos-globales)
    - [Formularios](#formularios)
    - [Multimedia](#multimedia)
3. [CSS](#css)
    - [Sintaxis Básica](#sintaxis-básica)
    - [Selectores Comunes](#selectores-comunes)
    - [Modelo de Caja](#modelo-de-caja)
    - [Flexbox](#flexbox)
    - [Grid](#grid)
4. [Notas y Tips](#notas-y-tips)

## Introducción

Bienvenido al curso de Lenguajes de Marcas y Sistemas de Información. En este documento encontrarás información relevante sobre los principales lenguajes de marcas como HTML y CSS, así como tips y notas importantes para tu aprendizaje.

## HTML

HTML (HyperText Markup Language) es el lenguaje estándar para crear páginas web. A continuación, se presenta información básica sobre su estructura y etiquetas más comunes.

### Estructura Básica

Un archivo HTML típico tiene la siguiente estructura:

```html
<!DOCTYPE html>
<html lang="es">
<head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Título de la Página</title>
</head>
<body>
     <h1>Encabezado Principal</h1>
     <p>Este es un párrafo de ejemplo.</p>
</body>
</html>
```

>[!NOTE]
> HTML es un lenguaje de marcado, no de programación. Se utiliza para estructurar el contenido de la web.

Además de las etiquetas básicas, un archivo HTML puede incluir:

- `<header>`: Encabezado de la página o sección.
- `<footer>`: Pie de página o sección.
- `<nav>`: Navegación.
- `<article>`: Contenido independiente.
- `<section>`: Sección de contenido.

### Etiquetas Comunes

- `<h1>` a `<h6>`: Encabezados de diferentes niveles.
- `<p>`: Párrafo.
- `<a>`: Enlace.
- `<img>`: Imagen.
- `<ul>`, `<ol>`, `<li>`: Listas desordenadas y ordenadas.
- `<div>`: División genérica.
- `<span>`: Contenedor en línea.

>[!TIP]
> Utiliza etiquetas semánticas como `<header>`, `<footer>`, `<article>`, y `<section>` para mejorar la accesibilidad y SEO de tu página.

### Atributos Globales

Los atributos globales pueden ser utilizados en cualquier elemento HTML:

- `class`: Define una o más clases para un elemento.
- `id`: Define un identificador único para un elemento.
- `style`: Define estilos CSS en línea.
- `title`: Proporciona información adicional sobre un elemento (tooltip).
- `data-*`: Atributos personalizados para almacenar datos adicionales.

### Formularios

Los formularios permiten la interacción del usuario con la página web:

```html
<form action="/submit" method="post">
     <label for="name">Nombre:</label>
     <input type="text" id="name" name="name">
     <input type="submit" value="Enviar">
</form>
```

- `<form>`: Contenedor del formulario.
- `<input>`: Campo de entrada.
- `<label>`: Etiqueta para un campo de entrada.
- `<button>`: Botón interactivo.

### Multimedia

HTML soporta la inclusión de contenido multimedia:

- `<audio>`: Reproduce archivos de audio.
- `<video>`: Reproduce archivos de video.
- `<iframe>`: Embebe contenido de otras fuentes.

```html
<audio controls>
     <source src="audio.mp3" type="audio/mpeg">
     Tu navegador no soporta el elemento de audio.
</audio>

<video width="320" height="240" controls>
     <source src="video.mp4" type="video/mp4">
     Tu navegador no soporta el elemento de video.
</video>
```

## CSS

CSS (Cascading Style Sheets) se utiliza para describir la presentación de un documento HTML. A continuación, se presenta información básica sobre su sintaxis y selectores más comunes.

### Sintaxis Básica

Un archivo CSS típico tiene la siguiente estructura:

```css
body {
     font-family: Arial, sans-serif;
     background-color: #f0f0f0;
}

h1 {
     color: #333;
}

p {
     font-size: 16px;
     line-height: 1.5;
}
```

>[!IMPORTANT]
> Siempre incluye el atributo `alt` en las imágenes para mejorar la accesibilidad y el SEO.

### Selectores Comunes

- `element`: Selecciona todos los elementos de ese tipo (e.g., `p`).
- `.class`: Selecciona todos los elementos con esa clase (e.g., `.container`).
- `#id`: Selecciona el elemento con ese ID (e.g., `#header`).

Además, CSS permite el uso de selectores avanzados como:

- `element element`: Selecciona todos los elementos dentro de otro elemento (e.g., `div p`).
- `element > element`: Selecciona todos los elementos hijos directos de otro elemento (e.g., `div > p`).
- `element + element`: Selecciona el elemento inmediatamente siguiente a otro (e.g., `h1 + p`).

### Modelo de Caja

El modelo de caja es fundamental para entender el diseño en CSS:

- `margin`: Espacio exterior alrededor del borde.
- `border`: Borde alrededor del padding y contenido.
- `padding`: Espacio interior alrededor del contenido.
- `content`: El contenido real del elemento.

```css
div {
     width: 300px;
     padding: 10px;
     border: 5px solid black;
     margin: 20px;
}
```

### Flexbox

Flexbox es un modelo de diseño unidimensional que facilita la alineación y distribución de elementos:

```css
.container {
     display: flex;
     justify-content: center;
     align-items: center;
}
```

- `display: flex`: Activa el modo flexbox.
- `justify-content`: Alinea los elementos horizontalmente.
- `align-items`: Alinea los elementos verticalmente.

### Grid

CSS Grid Layout es un sistema de diseño bidimensional:

```css
.container {
     display: grid;
     grid-template-columns: repeat(3, 1fr);
     gap: 10px;
}
```

- `display: grid`: Activa el modo grid.
- `grid-template-columns`: Define las columnas de la cuadrícula.
- `gap`: Espacio entre los elementos de la cuadrícula.

## Notas y Tips

>[!NOTE]
> CSS es un lenguaje de hojas de estilo en cascada, lo que significa que las reglas se aplican de arriba hacia abajo y pueden sobrescribirse.

>[!TIP]
> Utiliza clases en lugar de IDs para aplicar estilos a múltiples elementos.

Esperamos que este documento te sea de ayuda en tu aprendizaje de los lenguajes de marcas y sistemas de información. ¡Buena suerte!

