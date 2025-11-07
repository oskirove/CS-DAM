<?php
if (isset($_GET['uuid']) && is_numeric($_GET['uuid'])) {
    require_once '../modelos/modelo.php';

    $empleado = new Empleado();
    $dato= $empleado->edit($_GET['uuid']);

    require_once '../vistas/vista_editar.php';
}
