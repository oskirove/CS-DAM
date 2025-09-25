<?php

function calcularPrecioEntrada($edad) {
    
    $precio = 0;
        
    if ($edad < 9 || $edad > 65) {
        $precio = 0;
    } 
    elseif (($edad >= 9 && $edad <= 16) || ($edad >= 56 && $edad <= 65)) {
        $precio = 5;
    } 
    elseif ($edad >= 17 && $edad <= 25) {
        $precio = 8;
    } 
    else {
        $precio = 10; 
    }
    
    if ($precio === 0) {
        echo "Tienes $edad años. La entrada es gratis.";
    } else {
        echo "Tienes $edad años. El precio de tu entrada es de $precio €.";
    }
}

calcularPrecioEntrada(7); 
echo "<br>";

calcularPrecioEntrada(15);
echo "<br>";

calcularPrecioEntrada(22);
echo "<br>";

calcularPrecioEntrada(40); 
echo "<br>";

calcularPrecioEntrada(60); 
echo "<br>";

calcularPrecioEntrada(70);
echo "<br>";

calcularPrecioEntrada(8);
echo "<br>";

calcularPrecioEntrada(66);

?>