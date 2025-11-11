<?php

if (isset($_GET['id']) && is_numeric($_GET['id'])) {
    require_once '../modelos/modelo.php';

    $empleado = new Empleado();
    $result = $empleado->delete($_GET['id']);

    if ($result) {
        header("Location: controlador.php?msg=deleted");
    } else {
        header("Location: controlador.php?msg=error");
    }
}

?>
