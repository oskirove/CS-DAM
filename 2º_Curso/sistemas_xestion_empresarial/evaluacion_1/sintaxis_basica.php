<?php

// Array de datos
$libros = [
    [
        "titulo" => "Cien años de soledad",
        "autor" => "García Márquez",
        "categoria" => 0,
    ],
    [
        "titulo" => "1984",
        "autor" => "George Orwell",
        "categoria" => 1,
    ],
    [
        "titulo" => "El nombre de la rosa",
        "autor" => "Umberto Eco",
        "categoria" => 2,
    ],
    [
        "titulo" => "El código Da Vinci",
        "autor" => "Dan Brown",
        "categoria" => 3,
    ],
];

function infoLibro($libro) {
    return [
        "titulo_completo" => strtoupper($libro['titulo']),
        "autor" => $libro['autor'],
        "longitud_titulo" => strlen($libro['titulo'])
    ];
};

echo "<h1>Libros de mi biblioteca </h1>";
echo "<br>";

$contador = 0;
while($contador < count($libros)) {
    $info = infoLibro($libros[$contador]);
    echo "Titulo : {$info['titulo_completo']} | Autor : {$info['autor']} | longitud del titulo : {$info['longitud_titulo']}";
    echo "<br>";
    $contador++;
}

echo "<br>";

function filtroCategoria($tipo) {
    global $libros;

    switch($tipo) {
        case 0:
            $genero = "Narrativa";
            break;
        case 1:
            $genero = "historia";
            break;
        case 2: 
            $genero = "misterio";
            break;
        default:
            $genero = "otros";
    }
}

echo "Los libros con el $genero encontrados son: ";
echo "<br>";

$resultado = [];

foreach($libros as $indice => $libro) {
    foreach($libro as $clavecol => $valorcol) {
        if($clavecol == "categoria" && $valorcol == $tipo){
            $resultado[] = $libro['titulo'];
        }
    }
}

return $resultado;

echo "<h3>Filtro por categoria </h3>";
echo "<br>";

$arrayFinal = filtroCategoria(2);
print_r($arrayFinal);

?>