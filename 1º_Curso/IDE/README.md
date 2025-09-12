# Entornos de Desarrollo

## Índice
1. [Introducción](#introducción)
2. [Visual Studio Code](#visual-studio-code)
    - [Instalación](#instalación)
    - [Extensiones](#extensiones)
    - [Snippets](#snippets)
    - [Comandos Indispensables](#comandos-indispensables)
    - [Shortcuts de Teclado](#shortcuts-de-teclado)
        - [Navegación](#navegación)
        - [Ventanas y Pestañas](#ventanas-y-pestañas)
        - [Exploración y Paneles](#exploración-y-paneles)
        - [Edición y Formateo](#edición-y-formateo)
        - [Comandos y Configuración](#comandos-y-configuración)
        - [Terminal](#terminal)
        - [Plegado de Código](#plegado-de-código)
3. [Conclusión](#conclusión)

## Introducción
En este documento, exploraremos todo lo necesario para trabajar eficientemente con entornos de desarrollo, enfocándonos en Visual Studio Code (VS Code). Aprenderás sobre la instalación, configuración, uso de extensiones, creación de snippets, comandos indispensables y atajos de teclado relevantes.

## Visual Studio Code

### Instalación
Para instalar Visual Studio Code, sigue estos pasos:

1. Visita la [página oficial de descargas](https://code.visualstudio.com/Download).
2. Selecciona el instalador adecuado para tu sistema operativo.
3. Sigue las instrucciones del instalador.

>[!IMPORTANT]
> Asegúrate de tener permisos de administrador para instalar software en tu sistema.

### Extensiones
Las extensiones son una parte fundamental de VS Code. Aquí hay algunas esenciales:

- **Prettier**: Formateador de código.
- **ESLint**: Linter para JavaScript y TypeScript.
- **Live Server**: Servidor local para desarrollo web.

Para instalar una extensión:

1. Abre VS Code.
2. Ve a la pestaña de extensiones (`Ctrl+Shift+X`).
3. Busca la extensión deseada y haz clic en "Instalar".

>[!TIP]
> Puedes configurar las extensiones desde el archivo `settings.json` para personalizar su comportamiento.

### Snippets
Los snippets son fragmentos de código reutilizables. Para crear un snippet personalizado:

1. Abre la paleta de comandos (`Ctrl+Shift+P`).
2. Escribe `Preferences: Configure User Snippets` y selecciona el lenguaje deseado.
3. Añade tu snippet en el archivo JSON que se abre.

Ejemplo de snippet para JavaScript:
```json
{
  "Print to console": {
     "prefix": "log",
     "body": [
        "console.log('$1');"
     ],
     "description": "Log output to console"
  }
}
```

>[!NOTE]
> El campo `prefix` define el atajo que activará el snippet.

### Comandos Indispensables
Algunos comandos que debes conocer:

- `Ctrl+P`: Abre rápidamente un archivo.
- `Ctrl+Shift+P`: Abre la paleta de comandos.
- `Ctrl+` `: Abre la terminal integrada.

### Shortcuts de Teclado
Los atajos de teclado mejoran la productividad. Aquí algunos importantes:

#### Navegación
- `Ctrl+P`: Abrir rápidamente un archivo.
- `Ctrl+Tab`: Navegar entre archivos abiertos.
- `Ctrl+Shift+T`: Reabrir la última pestaña cerrada.
- `F12`: Ir a la definición.
- `Alt+F12`: Vista previa de la definición.

#### Ventanas y Pestañas
- `Ctrl+Shift+N`: Abrir una nueva ventana.
- `Ctrl+W`: Cerrar la ventana actual.
- `Ctrl+K Ctrl+W`: Cerrar todas las pestañas.

#### Exploración y Paneles
- `Ctrl+B`: Alternar la barra lateral.
- `Ctrl+Shift+E`: Mostrar el explorador de archivos.
- `Ctrl+Shift+G`: Mostrar el control de versiones.
- `Ctrl+Shift+D`: Mostrar el panel de depuración.
- `Ctrl+Shift+X`: Mostrar el panel de extensiones.
- `Ctrl+Shift+M`: Mostrar problemas.

#### Edición y Formateo
- `Alt+Shift+F`: Formatear el documento.
- `Ctrl+F`: Buscar en el archivo actual.
- `Ctrl+H`: Reemplazar en el archivo actual.

#### Comandos y Configuración
- `Ctrl+Shift+P`: Abrir la paleta de comandos.
- `Ctrl+K Ctrl+S`: Abrir la configuración de atajos de teclado.
- `Ctrl+K Z`: Entrar en modo Zen.

#### Terminal
- `Ctrl+` `: Abrir la terminal integrada.

#### Plegado de Código
- `Ctrl+K Ctrl+0`: Contraer todas las regiones.
- `Ctrl+K Ctrl+J`: Expandir todas las regiones.

>[!TIP]
> Puedes personalizar los atajos de teclado desde la configuración de VS Code.

## Conclusión
Visual Studio Code es una herramienta poderosa y flexible para el desarrollo de software. Con las extensiones adecuadas, snippets personalizados y el conocimiento de comandos y atajos de teclado, puedes optimizar tu flujo de trabajo y ser más productivo.
