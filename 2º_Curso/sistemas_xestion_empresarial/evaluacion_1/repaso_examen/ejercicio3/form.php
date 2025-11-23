<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <form method="post">
        <h1>Rellena el siguiente formulario para calcular el coste total del envío</h1>
        <label>Precio</label>
        <br>
        <input type="text" name="precio">
        <br>
        <label>Cantidad</label>
        <br>
        <input type="text" name="cantidad">
        <br>
        <label>Descuento</label>
        <br>
        <input type="text" name="descuento">
        <br>
        <label>IVA</label>
        <br>
        <input type="text" name="iva">
        <br>
        <label>Método de envío:</label>
        <select name="envio">
            <option value="tienda" selected>Recoger en tienda</option>
            <option value="domicilio">Envío a domicilio</option>
            <option value="express">Envío express</option>
        </select>

        <button type="submit">Calcular precio</button>
    </form>

    <?php
    if ($_SERVER["REQUEST_METHOD"] == 'POST') {

        $mensaje = "";

        if (isset($_POST['precio'], $_POST['cantidad'], $_POST['descuento'], $_POST['iva'], $_POST['envio'])) {
            $precio = $_POST['precio'];
            $cantidad = $_POST['cantidad'];
            $descuento = $_POST['descuento'];
            $iva = $_POST['iva'];
            $envio = $_POST['envio'];

            if ($precio == "" || $cantidad == "" || $descuento == "") {
                $mensaje = "Todos los campos son obligatorios";
                echo "<p>{$mensaje}<>";
            } else {
                $precioFinal = (($precio + $precio * $iva) - $descuento) * $cantidad;
                $mensaje = "El precio final es: " . $precioFinal . "y el metodo de emvio es a " . $envio . ".";
                echo "<p>{$mensaje}<>";
            }
        }
    }
    ?>
</body>

</html>