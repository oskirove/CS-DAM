<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario</title>
</head>
<body>
    <form method="POST" action="http://localhost:8080/tema5/rest/personas">
        <label for="id">id:</label>
        <input type="text" id="id" name="id" required><br><br>

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>
        
        <label for="casado">Casado:</label>
        <select name="casado" id="casado">
            <option value="true">Si</option>
            <option value="false">No</option>
        </select><br><br>
        
        <label for="sexo">Sexo:</label>
        <select name="sexo" id="sexo">
            <option value="masculino">Masculino</option>
            <option value="femenino">Femenino</option>
        </select><br><br>
        
        <button type="submit">Enviar</button>
    </form>
</body>
</html>