<?php

if (isset($_GET['id']) && is_numeric($_GET['id'])) {
    require_once '../modelos/modelo.php';

    $empleado = new Empleado();
    $dato = $empleado->edit($_GET['id']);

    require_once '../vistas/vista_editar.php';
}

if (isset($_POST['uuid']) && isset($_POST['nombre']) && isset($_POST['apellidos']) && isset($_POST['telefono']) && isset($_POST['departamento'])) {
    require_once '../modelos/modelo.php';

    $empleado = new Empleado();
    $result = $empleado->update($_POST['nombre'], $_POST['apellidos'], $_POST['telefono'], $_POST['departamento'], $_POST['uuid']);

    if ($result) {
        echo "<p style=\"color:green\">El usuario se ha actualizado correctamente</p>";
        header("refresh:2; url=controlador.php");
    } else {
        echo "<p style=\"color:red\">Error al actualizar el usuario</p>";
    }
}

?>
