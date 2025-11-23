<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>Rellena el siguiente formulario: </h1>
    <form action="accion.php" method="post">
        <label>Nombre</label> <br>
        <input type="text" name="nombre"><br>
        <label>Email</label><br>
        <input type="email" name="email"><br>
        <label>Teléfono</label><br>
        <input type="tel" name="telefono"><br>
        <label>Mensaje</label><br>
        <textarea name="mensaje" rows="5" cols="40">Escribe tu mensaje aquí...</textarea><br>
        <button type="submit">Enviar formulario</button>
    </form>
</body>
</html>