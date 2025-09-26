<?php
$colores = ['rojo', 'verde', 'amarillo', 'azul', 'rosa'];

$indice = array_search('azul', $colores);

if ($indice !== false) {
    unset($colores[$indice]);
}

foreach ($colores as $color) {
    echo $color . "\n";
}
?>