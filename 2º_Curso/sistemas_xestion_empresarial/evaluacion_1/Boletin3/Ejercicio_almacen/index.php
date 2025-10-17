<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/estilos/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <title>Revistas</title>
</head>

<style>
    body {
        background: linear-gradient(135deg, #f5f7fa, #e8eef8);
        display: flex;
        align-items: center;
        justify-content: center;
        min-height: calc(100vh - 56px);
        margin: 0;
        font-family: system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial;
    }

    section {
        width: 100%;
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 2rem;
    }

    .almacen-card {
        background: #ffffff;
        border-radius: 18px;
        box-shadow: 0 8px 24px rgba(15, 23, 42, 0.08);
        padding: 2rem;
        width: 680px;
        height: 270px;
        max-width: 95%;
        text-align: center;
        border: 1px solid rgba(0, 0, 0, 0.04);
    }

    .almacen-title {
        font-size: 3rem;
        font-weight: 700;
        margin-bottom: 1.25rem;
        color: #0b2545;
    }

    .btn-group {
        width: 100%;
        display: flex;
        gap: 0.5rem;
        justify-content: center;
    }

    .btn-group .btn {
        flex: 1;
        font-weight: bold;

    }

</style>

<body>
    <section>
        <div class="almacen-card" role="region" aria-label="Gestor Almacén">
            <div class="almacen-title">Gestor Almacén</div>
            <div class="btn-group" role="group" aria-label="">
                <button type="button" onsubmit="post" class="btn btn-primary">Agregar producto</button>
                <button type="button" class="btn btn-primary">Ver información</button>
                <button type="button" class="btn btn-primary">Eliminar producto</button>
                <button type="button" class="btn btn-primary">Valor total marca</button>
                <button type="button" class="btn btn-primary">Valor total estantería</button>
                <button type="button" class="btn btn-primary">Valor total almacén</button>
            </div>
        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>

</html>