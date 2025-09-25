<?php

function calcularAreaCirculo($r) {
  return pi() * pow($r, 2);
}

$radio = 10; 
$area = calcularAreaCirculo($radio);

echo "El área del círculo es: " . $area;

?>