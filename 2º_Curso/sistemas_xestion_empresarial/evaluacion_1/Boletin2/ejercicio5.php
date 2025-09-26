<?php
$meses = ['enero', 'febrero', 'marzo', 'abril', 'mayo', 'junio', 'julio', 'agosto', 'septiembre', 'octubre', 'noviembre', 'diciembre'];

$mesesConM = [];

foreach ($meses as $mes) {
    if (strtolower($mes[0]) === 'm') {
        $mesesConM[] = $mes;
    }
}

foreach ($mesesConM as $mes) {
    echo $mes . "\n";
}
?>
