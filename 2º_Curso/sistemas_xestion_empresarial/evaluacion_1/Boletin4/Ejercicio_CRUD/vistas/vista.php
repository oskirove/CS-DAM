<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de empleados</title>
</head>

<body>
    <h1>Listado de los empleados</h1>
    <table>
        <tr>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Teléfono</th>
            <th>Departamento</th>
        </tr>
        <?php
        for ($i = 0; $i < count($result); $i++) {
        ?>
            <tr>
                <td><?php echo $result[$i]["nombre"] ?></td>
                <td><?php echo $result[$i]["apellidos"] ?></td>
                <td><?php echo $result[$i]["telefono"] ?></td>
                <td><?php echo $result[$i]["departamento"] ?></td>
                <td><?php echo "<a href=\"../controladores/controlador_actualizar.php?id={$result[$i]['uuid']}\">Actualizar</a>" ?></td>
                <td><?php echo "<a href=\"../controladores/controlador_borrar.php?id={$result[$i]['uuid']}\">Borrar</a>" ?></td>
            </tr>
        <?php
        }
        ?>
    </table>
    <a href="../index.php">Inicio</a>
</body>

</html>