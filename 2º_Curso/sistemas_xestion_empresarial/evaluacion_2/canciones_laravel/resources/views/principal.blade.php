<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>@yield('titulo')</title>
    <style>
        table {
            border-collapse: collapse;
        }

        table,
        th,
        td {
            border: 1px, solid black;
        }

        th,
        td {
            padding: 6px
        }
    </style>
</head>

<body>
    <a href="{{ route('inicio') }}">Inicio</a>
    <a href="{{ route('formAgregar') }}">Agregar</a>
    @yield('contenido')
    <hr>
    <p>Crud creado con Laravel por Óscar.</p>
</body>

</html>
