# Bases de Datos - Ciclo Superior de DAM

## Índice
1. [Introducción](#introducción)
2. [Diseño de Bases de Datos](#diseño-de-bases-de-datos)
    - [Método de Entidad-Relación](#método-de-entidad-relación)
    - [Método Relacional](#método-relacional)
        - [Pasos para convertir un diagrama E/R en un esquema relacional](#pasos-para-convertir-un-diagrama-er-en-un-esquema-relacional)
        - [Tipos de relaciones y su implementación](#tipos-de-relaciones-y-su-implementación)
        - [Ejemplo de implementación](#ejemplo-de-implementación)
3. [Conclusión](#conclusión)

## Introducción
Bienvenido al apartado de bases de datos del ciclo superior de Desarrollo de Aplicaciones Multiplataforma (DAM). En este documento, aprenderás a diseñar bases de datos de manera profesional y eficiente.

## Diseño de Bases de Datos

### Método de Entidad-Relación
El método de entidad-relación (E/R) es una técnica de modelado de datos que te permite visualizar y estructurar la información de una base de datos de manera clara y lógica.

#### Pasos para diseñar una base de datos con el método E/R:
1. **Identificar entidades**: Determina los objetos principales que serán almacenados en la base de datos.
2. **Definir relaciones**: Establece cómo se relacionan las entidades entre sí.
3. **Especificar atributos**: Define las propiedades de cada entidad y relación.
4. **Crear el diagrama E/R**: Representa gráficamente las entidades, relaciones y atributos.

>[!TIP]
> Utiliza herramientas como **MySQL Workbench** o **Lucidchart** para crear tus diagramas E/R de manera más eficiente.

>[!NOTE]
> Asegúrate de que cada entidad tenga una clave primaria única para identificar cada registro de manera inequívoca.

### Método Relacional
Una vez que hayas creado el diagrama E/R, el siguiente paso es convertirlo en un esquema relacional. Este método se enfoca en la organización de los datos en tablas y la definición de relaciones entre ellas.

#### Pasos para convertir un diagrama E/R en un esquema relacional:
1. **Crear tablas**: Cada entidad del diagrama E/R se convierte en una tabla.
2. **Definir columnas**: Los atributos de las entidades se convierten en columnas de las tablas.
3. **Establecer claves primarias**: Asigna claves primarias a las tablas para identificar de manera única cada registro.
4. **Definir claves foráneas**: Establece claves foráneas para representar las relaciones entre tablas.

#### Tipos de relaciones y su implementación:
- **Relación 1:N (uno a muchos)**: La clave primaria de la tabla del lado "uno" se convierte en una clave foránea en la tabla del lado "muchos".
- **Relación N:M (muchos a muchos)**: Se crea una tabla intermedia que contiene las claves primarias de ambas tablas relacionadas. Estas claves primarias actúan como claves foráneas en la tabla intermedia.
- **Relación 1:1 (uno a uno)**: La clave primaria de una tabla se convierte en una clave foránea única en la otra tabla. Alternativamente, ambas tablas pueden compartir la misma clave primaria.

#### Ejemplo de implementación:
- **Relación 1:N**: Un cliente puede tener múltiples pedidos.
    - Tabla `Clientes`: `ClienteID` (PK)
    - Tabla `Pedidos`: `PedidoID` (PK), `ClienteID` (FK)
- **Relación N:M**: Un estudiante puede estar inscrito en múltiples cursos y un curso puede tener múltiples estudiantes.
    - Tabla `Estudiantes`: `EstudianteID` (PK)
    - Tabla `Cursos`: `CursoID` (PK)
    - Tabla `Inscripciones`: `EstudianteID` (FK), `CursoID` (FK)
- **Relación 1:1**: Cada persona tiene un pasaporte único.
    - Tabla `Personas`: `PersonaID` (PK)
    - Tabla `Pasaportes`: `PasaporteID` (PK, FK)

>[!IMPORTANT]
> La integridad referencial es crucial en el método relacional. Asegúrate de definir correctamente las claves foráneas para mantener la consistencia de los datos.

## Conclusión
El diseño de bases de datos es una habilidad esencial en el desarrollo de aplicaciones. Dominar los métodos de entidad-relación y relacional te permitirá crear bases de datos robustas y eficientes. ¡Sigue practicando y mejorando tus habilidades!
