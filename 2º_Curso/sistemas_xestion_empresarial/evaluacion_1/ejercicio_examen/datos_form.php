<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión del formulario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <?php
    function formato($dato)
    {
        $dato = trim($dato);
        $dato = stripslashes($dato);
        $dato = htmlspecialchars($dato);
        return $dato;
    }

    $error = false;

    if ($_SERVER['REQUEST_METHOD'] == "POST") {

        if (!isset($_POST['nombre']) || empty($_POST['nombre'])) {
            echo "<p class='text-danger'>El campo <strong>nombre</strong> es obligatorio.</p>";
            $error = true;
        } else {
            $nombre = formato($_POST['nombre']);
        }

        if (!isset($_POST['apellidos']) || empty($_POST['apellidos'])) {
            echo "<p class='text-danger'>El campo <strong>apellidos</strong> es obligatorio.</p>";
            $error = true;
        } else {
            $apellidos = formato($_POST['apellidos']);
        }

        if (!isset($_POST['usuario']) || empty($_POST['usuario'])) {
            echo "<p class='text-danger'>El campo <strong>usuario</strong> es obligatorio.</p>";
            $error = true;
        } else {
            $usuario = formato($_POST['usuario']);
        }

        if (!isset($_POST['correo']) || empty($_POST['correo'])) {
            echo "<p class='text-danger'>El campo <strong>correo</strong> no puede estar vacío.</p>";
            $error = true;
        } else {
            $correo = filter_var($_POST['correo'], FILTER_SANITIZE_EMAIL);
            if (!filter_var($correo, FILTER_VALIDATE_EMAIL)) {
                echo "<p class='text-danger'>El <strong>correo</strong> introducido no es válido.</p>";
                $error = true;
            }
        }

        if (!isset($_POST['plan']) || empty($_POST['plan'])) {
            echo "<p class='text-danger'>Debe seleccionar un <strong>plan</strong>.</p>";
            $error = true;
        } else {
            $plan = formato($_POST['plan']);
        }

        if (isset($_POST['publicaciones']) && is_array($_POST['publicaciones'])) {
            $publicaciones = array_map('formato', $_POST['publicaciones']);
        } else {
            $publicaciones = [];
        }

        $recibir_info = isset($_POST['recibir_info']) ? "Sí" : "No";
    }
    ?>
</head>

<body class="bg-light p-5">

    <div class="container">

        <?php if ($_SERVER['REQUEST_METHOD'] == "POST" && !$error): ?>
            <h1 class="display-6 mb-4 text-center">Datos introducidos en la inscripción</h1>

            <ol class="list-group list-group-numbered shadow-sm">
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Nombre y Apellidos</div>
                        <?= "$nombre $apellidos" ?>
                    </div>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Usuario</div>
                        <?= $usuario ?>
                    </div>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Correo electrónico</div>
                        <?= $correo ?>
                    </div>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Plan seleccionado</div>
                        <?= $plan ?>
                    </div>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Publicaciones elegidas</div>
                        <?= empty($publicaciones) ? "Ninguna" : implode(', ', $publicaciones) ?>
                    </div>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">¿Desea recibir información?</div>
                        <?= $recibir_info ?>
                    </div>
                </li>
            </ol>

        <?php elseif ($error): ?>
            <div class="alert alert-danger mt-4" role="alert">
                Corrige los errores mostrados arriba y vuelve a enviar el formulario.
            </div>
        <?php else: ?>
            <div class="alert alert-warning mt-4" role="alert">
                No se han recibido datos. Por favor, completa el formulario.
            </div>
        <?php endif; ?>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>

</html>