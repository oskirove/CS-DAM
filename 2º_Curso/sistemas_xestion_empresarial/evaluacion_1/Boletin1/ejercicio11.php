<?php

$tamaño = 10;

echo "<table border='1' style='border-collapse: collapse;'>";

for ($i = 1; $i <= $tamaño; $i++) {
    echo "<tr>";
    
    for ($j = 1; $j <= $tamaño; $j++) {
        
        echo "<td>" . ($i * $j) . "</td>";
    }
    
    echo "</tr>";
}

echo "</table>";

?>