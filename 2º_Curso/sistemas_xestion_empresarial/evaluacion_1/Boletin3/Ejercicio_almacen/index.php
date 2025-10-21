<?php
require_once 'clases/Almacen.php';
require_once 'clases/Bebidas.php';
require_once 'clases/Agua.php';
require_once 'clases/Azucarada.php';

session_start();

// Inicializar el almacén si no existe en la sesión
if (!isset($_SESSION['almacen'])) {
    $_SESSION['almacen'] = new Almacen();
}

$mensaje = '';
$resultado = '';

// Procesar formularios
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if (isset($_POST['action'])) {
        switch ($_POST['action']) {
            case 'agregar':
                if (
                    isset($_POST['tipo']) && isset($_POST['id']) && isset($_POST['marca']) &&
                    isset($_POST['precio']) && isset($_POST['capacidad'])
                ) {

                    $bebida = null;
                    if ($_POST['tipo'] === 'agua') {
                        $bebida = new Agua(
                            intval($_POST['id']),
                            $_POST['marca'],
                            floatval($_POST['precio']),
                            floatval($_POST['capacidad']),
                            $_POST['manantial']
                        );
                    } else if ($_POST['tipo'] === 'azucarada') {
                        $bebida = new Azucarada(
                            intval($_POST['id']),
                            $_POST['marca'],
                            floatval($_POST['precio']),
                            floatval($_POST['capacidad']),
                            floatval($_POST['porcentajeAzucar']),
                            isset($_POST['promocion'])
                        );
                    }

                    if ($bebida && $_SESSION['almacen']->agregarProducto($bebida)) {
                        $mensaje = "Producto agregado correctamente";
                    } else {
                        $mensaje = "Error al agregar el producto";
                    }
                }
                break;

            case 'eliminar':
                if (isset($_POST['id_eliminar'])) {
                    if ($_SESSION['almacen']->eliminarProducto(intval($_POST['id_eliminar']))) {
                        $mensaje = "Producto eliminado correctamente";
                    } else {
                        $mensaje = "No se encontró el producto";
                    }
                }
                break;

            case 'valor_marca':
                if (isset($_POST['marca'])) {
                    $total = $_SESSION['almacen']->calcularPrecioMarca($_POST['marca']);
                    $resultado = "Valor total de la marca {$_POST['marca']}: {$total}€";
                }
                break;

            case 'valor_estanteria':
                if (isset($_POST['estanteria'])) {
                    $total = $_SESSION['almacen']->calcularPrecioEstanteria(intval($_POST['estanteria']));
                    $resultado = "Valor total de la estantería {$_POST['estanteria']}: {$total}€";
                }
                break;

            case 'valor_total':
                $total = $_SESSION['almacen']->calcularPrecioTotal();
                $resultado = "Valor total del almacén: {$total}€";
                break;

            case 'ver_info':
                $resultado = $_SESSION['almacen']->mostrarInformacion();
                break;
        }
    }
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/estilos/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <title>Gestión de Almacén de Bebidas</title>
</head>

<style>
    body {
        background: linear-gradient(135deg, #f5f7fa, #e8eef8);
        display: flex;
        align-items: center;
        justify-content: center;
        min-height: calc(100vh - 56px);
        margin: 0;
        font-family: system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial;
    }

    section {
        width: 100%;
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 2rem;
    }

    .almacen-card {
        background: #ffffff;
        border-radius: 18px;
        box-shadow: 0 8px 24px rgba(15, 23, 42, 0.08);
        padding: 2rem;
        width: 680px;
        height: 270px;
        max-width: 95%;
        text-align: start;
        border: 1px solid rgba(0, 0, 0, 0.04);
    }

    .almacen-title {
        font-size: 3rem;
        font-weight: 700;
        margin-bottom: 1.25rem;
        color: #0b2545;
    }

    .btn-group {
        width: 100%;
        display: flex;
        gap: 0.5rem;
        justify-content: center;
    }

    .btn-group .btn {
        flex: 1;
        font-weight: bold;

    }
</style>

<body>
    <section>
        <div class="almacen-card" role="region" aria-label="Gestor Almacén">
            <div class="almacen-title">Gestor Almacén</div>
            <div class="btn-group" role="group" aria-label="">

                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                    Agregar producto
                </button>

                <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel">Agrega un producto al almacén</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form class="row g-3">
                                    <div class="col-md-6">
                                        <label for="inputID" class="form-label">ID</label>
                                        <input type="text" class="form-control" id="inputID">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="inputTipo" class="form-label">Tipo</label>
                                        <select id="inputTipo" class="form-select">
                                            <option value="agua" selected>Agua</option>
                                            <option value="refresco">Refresco</option>
                                        </select>
                                    </div>
                                    <div class="col-md-2">
                                        <label for="inputPrecio" class="form-label">Precio</label>
                                        <input type="text" class="form-control" id="inputPrecio">
                                    </div>

                                    <div class="col-md-12">
                                        <label for="inputMarca" class="form-label">Marca</label>
                                        <input type="text" class="form-control" id="inputMarca">
                                    </div>

                                    <div class="col-12">
                                        <label for="inputManantial" class="form-label">Manantial</label>
                                        <input type="text" class="form-control" id="inputManantial" placeholder="Grand Prismatic Spring">
                                    </div>

                                    <div class="col-12">
                                        <label for="inputAzucar" class="form-label">Porcentaje de azucar</label>
                                        <input type="text" class="form-control" id="inputAzucar" placeholder="15">
                                    </div>

                                    <div class="col-12">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" id="check">
                                            <label class="form-check-label" for="check">
                                                Este producto tiene una oferta.
                                            </label>
                                        </div>
                                    </div>

                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                        <button type="submit" class="btn btn-primary">Añadir</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <button type="button" class="btn btn-primary">Ver información</button>

                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                    Eliminar producto
                </button>

                <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel">Elimina un producto del almacén</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                ...
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-primary">Eliminar</button>
                            </div>
                        </div>
                    </div>
                </div>

                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                    Valor marca
                </button>

                <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel">Consulta el valor total de una marca</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                ...
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-primary">Consultar</button>
                            </div>
                        </div>
                    </div>
                </div>

                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                    Valor estantería
                </button>

                <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel">Consulta el valor total de una estantería</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <select class="form-select" aria-label="Selecciona una estanteria">
                                    <option value="0" selected>Primera</option>
                                    <option value="1">Segunda</option>
                                    <option value="2">Tercera</option>
                                    <option value="3">Cuarta</option>
                                </select>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-primary">Consultar</button>
                            </div>
                        </div>
                    </div>
                </div>
                <button type="button" class="btn btn-primary">Valor total almacén</button>
            </div>
        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            const tipoSelect = document.getElementById("inputTipo");
            const manantialDiv = document.getElementById("inputManantial").parentElement;
            const azucarDiv = document.getElementById("inputAzucar").parentElement;
            const check = document.getElementById("check").parentElement;

            function actualizarVisibilidad() {
                const tipo = tipoSelect.value;
                if (tipo === "agua") {
                    manantialDiv.style.display = "block";
                    azucarDiv.style.display = "none";
                    check.style.display = "none"
                } else if (tipo === "refresco") {
                    manantialDiv.style.display = "none";
                    azucarDiv.style.display = "block";
                    check.style.display = "block"

                }
            }

            tipoSelect.addEventListener("change", actualizarVisibilidad);

            actualizarVisibilidad();
        });
    </script>
</body>

</html>