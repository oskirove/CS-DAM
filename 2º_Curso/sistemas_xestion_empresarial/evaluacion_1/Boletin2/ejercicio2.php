<?php
function contarLetra($frase, $letra) {
    $total = 0;
    $longitud = strlen($frase);

    for ($i = 0; $i < $longitud; $i++) {
        if ($frase[$i] === $letra) {
            $total += 1;
        }
    }

    return $total;
}

$frase = "Hola mundo";
$letra = "o";
echo "La letra '$letra' aparece " . contarLetra($frase, $letra) . " veces.";
?>