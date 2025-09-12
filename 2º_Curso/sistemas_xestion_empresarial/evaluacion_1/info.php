<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resumen Visual de PHP</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background: #f4f4f4; }
        h1, h2 { color: #2c3e50; }
        pre { background: #eaeaea; padding: 10px; border-radius: 12px; }
        section { background: #fff; padding: 20px; margin-bottom: 20px; border-radius: 18px; box-shadow: 0 2px 6px #ccc; }
        code { color: #c0392b; }
    </style>
</head>
<body>
    <h1>Resumen Visual de PHP</h1>

    <section>
        <h2>¿Qué es PHP?</h2>
        <p>PHP es un lenguaje de programación del lado del servidor, ampliamente usado para el desarrollo web. Permite generar contenido dinámico, gestionar bases de datos, sesiones y mucho más.</p>
        <pre>
&lt;?php
// Este es un comentario de una línea
# Otro comentario de una línea
/*
Comentario
de varias líneas
*/
echo "¡Hola mundo!";
?&gt;
        </pre>
    </section>

    <section>
        <h2>Variables</h2>
        <p>Las variables en PHP comienzan con <code>$</code> y pueden almacenar diferentes tipos de datos:</p>
        <pre>
&lt;?php
$nombre = "Juan";
$edad = 20;
$altura = 1.75;
$esEstudiante = true;

echo "Nombre: $nombre\n";
echo "Edad: $edad\n";
echo "Altura: $altura metros\n";
echo "¿Es estudiante?: " . ($esEstudiante ? "Sí" : "No") . "\n";

// Tipos de datos
var_dump($nombre);
var_dump($edad);
var_dump($altura);
var_dump($esEstudiante);
?&gt;
        </pre>
    </section>

    <section>
        <h2>Arrays</h2>
        <p>PHP soporta arrays indexados y asociativos, además de arrays multidimensionales:</p>
        <pre>
&lt;?php
// Array indexado
$frutas = ["Manzana", "Banana", "Naranja"];
foreach ($frutas as $fruta) {
    echo $fruta . "\n";
}

// Array asociativo
$persona = ["nombre" => "Ana", "edad" => 25];
foreach ($persona as $clave => $valor) {
    echo "$clave: $valor\n";
}

// Array multidimensional
$alumnos = [
    ["nombre" => "Luis", "nota" => 8],
    ["nombre" => "Marta", "nota" => 9]
];
foreach ($alumnos as $alumno) {
    echo $alumno["nombre"] . " tiene nota " . $alumno["nota"] . "\n";
}
?&gt;
        </pre>
    </section>

    <section>
        <h2>Operadores</h2>
        <p>PHP incluye operadores aritméticos, de comparación, lógicos y de asignación:</p>
        <pre>
&lt;?php
$a = 5;
$b = 3;
echo $a + $b; // Suma
echo $a - $b; // Resta
echo $a * $b; // Multiplicación
echo $a / $b; // División

// Comparación
var_dump($a == $b);
var_dump($a > $b);

// Lógicos
$esMayor = ($a > $b) && ($a > 0);
var_dump($esMayor);
?&gt;
        </pre>
    </section>

    <section>
        <h2>Estructuras de Control</h2>
        <p>PHP permite controlar el flujo del programa con condicionales y bucles:</p>
        <pre>
&lt;?php
$nota = 7;
if ($nota >= 5) {
    echo "Aprobado";
} else {
    echo "Suspendido";
}

for ($i = 1; $i <= 5; $i++) {
    echo "Número: $i\n";
}

$contador = 0;
while ($contador < 3) {
    echo "Contador: $contador\n";
    $contador++;
}
?&gt;
        </pre>
    </section>

    <section>
        <h2>Funciones</h2>
        <p>Las funciones permiten reutilizar código y pueden tener parámetros y valores de retorno:</p>
        <pre>
&lt;?php
function saludar($nombre) {
    return "Hola, $nombre!";
}

function sumar($a, $b = 0) {
    return $a + $b;
}

echo saludar("Carlos") . "\n";
echo "Suma: " . sumar(5, 3) . "\n";
echo "Suma con valor por defecto: " . sumar(5) . "\n";
?&gt;
        </pre>
    </section>

    <section>
        <h2>Clases y Objetos</h2>
        <p>PHP es orientado a objetos y permite definir clases, propiedades y métodos:</p>
        <pre>
&lt;?php
class Persona {
    public $nombre;
    private $edad;

    public function __construct($nombre, $edad) {
        $this->nombre = $nombre;
        $this->edad = $edad;
    }

    public function saludar() {
        return "Hola, soy $this->nombre y tengo $this->edad años";
    }
}

$persona = new Persona("Lucía", 30);
echo $persona->saludar();
?&gt;
        </pre>
    </section>

    <section>
        <h2>Superglobales</h2>
        <p>Variables especiales como <code>$_GET</code>, <code>$_POST</code>, <code>$_SESSION</code>, <code>$_COOKIE</code>, <code>$_SERVER</code>:</p>
        <pre>
&lt;?php
// Ejemplo de $_GET
// URL: info.php?nombre=Pedro
if (isset($_GET['nombre'])) {
    echo "Hola, " . htmlspecialchars($_GET['nombre']);
}

// Ejemplo de $_POST
// Formulario: &lt;form method="post"&gt;
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['mensaje'])) {
    echo "Mensaje recibido: " . htmlspecialchars($_POST['mensaje']);
}

// Ejemplo de $_SESSION
session_start();
$_SESSION['usuario'] = "admin";
echo "Usuario en sesión: " . $_SESSION['usuario'];

// Ejemplo de $_COOKIE
setcookie("tema", "oscuro", time() + 3600);
if (isset($_COOKIE['tema'])) {
    echo "Tema: " . $_COOKIE['tema'];
}
?&gt;
        </pre>
    </section>

    <section>
        <h2>Manejo de Archivos</h2>
        <p>PHP permite leer y escribir archivos fácilmente:</p>
        <pre>
&lt;?php
// Escribir en un archivo
file_put_contents("ejemplo.txt", "Hola desde PHP!");

// Leer un archivo
$contenido = file_get_contents("ejemplo.txt");
echo $contenido;

// Abrir y leer línea por línea
$archivo = fopen("ejemplo.txt", "r");
while (($linea = fgets($archivo)) !== false) {
    echo $linea;
}
fclose($archivo);
?&gt;
        </pre>
    </section>

    <section>
        <h2>Conexión a Base de Datos (MySQL)</h2>
        <p>PHP se conecta a bases de datos usando <code>mysqli</code> o <code>PDO</code>:</p>
        <pre>
&lt;?php
// Conexión con mysqli
$conexion = new mysqli("localhost", "usuario", "contraseña", "basedatos");
if ($conexion->connect_error) {
    die("Error de conexión: " . $conexion->connect_error);
}
$resultado = $conexion->query("SELECT nombre FROM usuarios");
while ($fila = $resultado->fetch_assoc()) {
    echo $fila["nombre"] . "\n";
}
$conexion->close();

// Conexión con PDO
try {
    $pdo = new PDO("mysql:host=localhost;dbname=basedatos", "usuario", "contraseña");
    foreach ($pdo->query("SELECT nombre FROM usuarios") as $fila) {
        echo $fila["nombre"] . "\n";
    }
} catch (PDOException $e) {
    echo "Error: " . $e->getMessage();
}
?&gt;
        </pre>
    </section>
</body>
</html>