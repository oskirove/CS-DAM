<?php

function comprobarMultiplo($numero1, $numero2) {

    if ($numero1 % $numero2 == 0) {
        echo "$numero1 es múltiplo de $numero2 \n";
    } else {
        echo "$numero1}** no es múltiplo de $numero2 \n";
    }
}

comprobarMultiplo(20, 4);

?>