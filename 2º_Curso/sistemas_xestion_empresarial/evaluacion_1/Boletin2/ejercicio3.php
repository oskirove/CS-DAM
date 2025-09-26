<?php
function validarContraseña($contrasena) {
    $longitud = strlen($contrasena);
    
    if ($longitud < 8 || $longitud > 12) {
        return false;
    }

    if (is_numeric($contrasena[0])) {
        return false;
    }

    return true;
}

$prueba1 = "abc123456";
$prueba2 = "1abc123456";
$prueba3 = "abc123";

echo validarContraseña($prueba2) ? "Válida" : "Inválida";
?>