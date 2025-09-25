<?php

function calcularPremioBingo($edad) {
    
    $edadMinima = 75;
    $edadMaxima = 80;
    $precioEdad = 0.05;
    
    if ($edad >= $edadMinima && $edad <= $edadMaxima) {
        
        $premio = $edad * $precioEdad;
        
        return "Con $edad años ganas $premio €.";
        
    } else {
        return "Con $edad años no puedes participar. Solo es para edades entre $edadMinima y $edadMaxima años.";
    }
}

echo calcularPremioBingo(75);
echo "<br>";

echo calcularPremioBingo(80);
echo "<br>";

echo calcularPremioBingo(74);
echo "<br>";

echo calcularPremioBingo(81);

?>