<?php
$fecha = date("d/m/Y H:i");
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    if (isset($_POST['nombre'], $_POST['email'], $_POST['telefono'], $_POST['mensaje'])) {
        $nombre = $_POST['nombre'];
        $email = $_POST['email'];
        $telefono = $_POST['telefono'];
        $mensaje = $_POST['mensaje'];

        if ($nombre == "" || $email == "" || $telefono == "" || $mensaje == "") {
            $mensaje = "Los campos no pueden estar vacios";
            echo "<p>{$mensaje}</p>";
        } else {
            echo "<p>El mensaje fue enviado por {$nombre}, telefono {$telefono}. Su email es: {$email}. Enviado el {$fecha}</p>";
        }
    }
}
