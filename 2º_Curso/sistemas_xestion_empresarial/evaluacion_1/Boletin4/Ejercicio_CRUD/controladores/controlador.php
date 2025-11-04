<?php

    require_once '../modelos/modelo.php';

    $empleado = new Empleado();
    $result = $empleado -> getEmpleado();

    require_once '../vistas/vista.php'

?>
