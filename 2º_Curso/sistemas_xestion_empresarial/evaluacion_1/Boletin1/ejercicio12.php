<?php

function calcularFactorial($numero) {
    
    if ($numero === 0) {
        echo "El factorial de 0 es 1";
        return;
    }

    $contador = $numero;
    $factorial = 1;

    do {
        $factorial *= $contador; 
        
        $contador--;

    } while ($contador >= 1);

    echo "El factorial de $numero es $factorial.";
}

calcularFactorial(5);

?>