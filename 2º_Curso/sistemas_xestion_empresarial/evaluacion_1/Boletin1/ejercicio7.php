<?php

function calcularPrecio($mascota) {

    $tipoMascota = strtolower($mascota);
    $precio = 0;
    
    switch ($tipoMascota) {
        
        case 'huron':
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
    
    echo "El precio para un $tipoMascota es de $precio €";
}

calcularPrecio('Gato');
echo "<br>";

calcularPrecio('Perro');
echo "<br>";

calcularPrecio('Loro');
echo "<br>";

calcularPrecio('Huron');
echo "<br>";

calcularPrecio('Conejo');

?>