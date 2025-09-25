<?php

function esPar($numero) {
    if ($numero % 2 == 0) {
        echo "El número $numero es par.";
    } else {
        echo "El número $numero es impar.";
    }
}

esPar(10); 
echo "<br>";

esPar(7);
echo "<br>";

esPar(0);
echo "<br>";

?>