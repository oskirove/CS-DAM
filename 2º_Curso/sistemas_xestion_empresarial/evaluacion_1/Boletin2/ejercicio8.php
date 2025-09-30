<?php
$nombres = ["Carlos Álvarez", "Laura López", "Rosa Márquez", "Jorge Tiras"];
$materias = ["Lengua", "Historia", "Inglés", "Matemáticas"];

echo "<table border='1' style='border-collapse: collapse; text-align: center;'>";
echo "<tr><th></th>";

foreach ($materias as $materia) {
    echo "<th>$materia</th>";
}

echo "</tr>";

foreach ($nombres as $nombre) {
    echo "<tr><td>$nombre</td>";
    foreach ($materias as $materia) {
        echo "<td>" . rand(0, 10) . "</td>";
    }
    echo "</tr>";
}

echo "</table>";
