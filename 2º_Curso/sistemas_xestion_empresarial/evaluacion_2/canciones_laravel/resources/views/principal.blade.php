<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>@yield('titulo')</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Inter', -apple-system, BlinkMacSystemFont, sans-serif;
            background: linear-gradient(135deg, #1a1a2e 0%, #16213e 50%, #0f3460 100%);
            min-height: 100vh;
            color: #e4e4e7;
            padding: 2rem;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
        }

        /* Navegación */
        nav {
            display: flex;
            gap: 1rem;
            margin-bottom: 2rem;
            padding: 1rem 1.5rem;
            background: rgba(255, 255, 255, 0.05);
            backdrop-filter: blur(10px);
            border-radius: 12px;
            border: 1px solid rgba(255, 255, 255, 0.1);
        }

        nav a {
            color: #a5b4fc;
            text-decoration: none;
            font-weight: 500;
            padding: 0.5rem 1rem;
            border-radius: 8px;
            transition: all 0.3s ease;
        }

        nav a:hover {
            background: rgba(165, 180, 252, 0.15);
            color: #c7d2fe;
            transform: translateY(-2px);
        }

        /* Título */
        h1 {
            font-size: 2.5rem;
            font-weight: 700;
            background: linear-gradient(90deg, #a5b4fc, #818cf8, #c084fc);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            background-clip: text;
            margin-bottom: 2rem;
            text-align: center;
        }

        /* Tabla */
        .table-container {
            background: rgba(255, 255, 255, 0.03);
            backdrop-filter: blur(20px);
            border-radius: 16px;
            border: 1px solid rgba(255, 255, 255, 0.08);
            overflow: hidden;
            box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.4);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        thead {
            background: linear-gradient(90deg, rgba(99, 102, 241, 0.3), rgba(168, 85, 247, 0.3));
        }

        th {
            padding: 1rem 1.5rem;
            text-align: left;
            font-weight: 600;
            font-size: 0.875rem;
            text-transform: uppercase;
            letter-spacing: 0.05em;
            color: #c7d2fe;
            border-bottom: 1px solid rgba(255, 255, 255, 0.1);
        }

        td {
            padding: 1rem 1.5rem;
            border-bottom: 1px solid rgba(255, 255, 255, 0.05);
            transition: all 0.3s ease;
        }

        tbody tr {
            transition: all 0.3s ease;
        }

        tbody tr:hover {
            background: rgba(99, 102, 241, 0.1);
        }

        tbody tr:hover td {
            color: #fff;
        }

        tbody tr:last-child td {
            border-bottom: none;
        }

        /* Botones de acción */
        .btn {
            display: inline-flex;
            align-items: center;
            gap: 0.5rem;
            padding: 0.5rem 1rem;
            font-size: 0.875rem;
            font-weight: 500;
            text-decoration: none;
            border-radius: 8px;
            transition: all 0.3s ease;
            cursor: pointer;
            border: none;
        }

        .btn-edit {
            background: rgba(59, 130, 246, 0.2);
            color: #60a5fa;
            border: 1px solid rgba(59, 130, 246, 0.3);
        }

        .btn-edit:hover {
            background: rgba(59, 130, 246, 0.3);
            transform: translateY(-1px);
            box-shadow: 0 4px 12px rgba(59, 130, 246, 0.3);
        }

        .btn-delete {
            background: rgba(239, 68, 68, 0.2);
            color: #f87171;
            border: 1px solid rgba(239, 68, 68, 0.3);
        }

        .btn-delete:hover {
            background: rgba(239, 68, 68, 0.3);
            transform: translateY(-1px);
            box-shadow: 0 4px 12px rgba(239, 68, 68, 0.3);
        }

        /* Footer */
        footer {
            margin-top: 3rem;
            padding-top: 1.5rem;
            border-top: 1px solid rgba(255, 255, 255, 0.1);
            text-align: center;
            color: #71717a;
            font-size: 0.875rem;
        }

        /* Mensaje vacío */
        .empty-state {
            text-align: center;
            padding: 3rem;
            color: #71717a;
        }

        .empty-state svg {
            width: 64px;
            height: 64px;
            margin-bottom: 1rem;
            opacity: 0.5;
        }
    </style>
</head>

<body>
    <div class="container">
        <nav>
            <a href="{{ route('inicio') }}">🏠 Inicio</a>
            {{-- <a href="{{ route('formAgregar') }}">➕ Agregar</a> --}}
        </nav>
        
        @yield('contenido')
        
        <footer>
            <p>Crud creado con Laravel por Óscar © {{ date('Y') }}</p>
        </footer>
    </div>
</body>

</html>
