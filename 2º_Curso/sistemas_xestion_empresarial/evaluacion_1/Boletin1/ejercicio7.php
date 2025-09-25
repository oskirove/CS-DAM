<?php

function calcularPrecioPasaje($mascota) {

    $tipo_mascota = strtolower($mascota);
    $precio = 0;
    
    switch ($tipo_mascota) {
        
        case 'hurón':
            $precio = 1.00;
            break;
        case 'gato':
            $precio = 1.00;
            break;
            
        case 'perro':
            $precio = 1.50;
            break;
            
        case 'loro':
            $precio = 2.00;
            break;
            
        default:
            echo "$mascota no permitido";
            return;
    }
    
    echo "El precio para un $tipo_mascota es de $precio €";
}

calcularPrecioPasaje('Gato');
echo "<br>";

calcularPrecioPasaje('Perro');
echo "<br>";

calcularPrecioPasaje('Loro');
echo "<br>";

calcularPrecioPasaje('Hurón');
echo "<br>";

calcularPrecioPasaje('Conejo');

?>