<?php

$fin = 10000;

$a = 0;
$b = 1;

echo "0, 1";

while ($b <= $fin) {
    
    $siguiente = $a + $b;

    if ($siguiente > $fin) {
        break;
    }

    echo ", " . $siguiente;

    $a = $b;
    $b = $siguiente;
}

echo "<br>";
echo "Ultimo número: $a";
echo "<br>";
echo"número que excede 10000: $siguiente.";

?>