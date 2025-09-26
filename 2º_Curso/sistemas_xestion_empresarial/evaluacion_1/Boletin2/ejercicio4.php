<?php
$pares = array();

for ($i = 0; $i < 10; $i++) {
    $pares[$i] = $i * 2;
}

foreach ($pares as $numero) {
    echo $numero . "\n";
}

?>