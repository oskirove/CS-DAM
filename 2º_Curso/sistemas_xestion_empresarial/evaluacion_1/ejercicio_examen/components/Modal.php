<?php

function renderModal($id, $title)
{
    ob_start();
?>
    <style>
        .btn-primary {
            background-color: #e9e2c9;
            border: none;
            transition: background-color 0.4s ease-in-out, transform 0.4s ease-in-out, box-shadow 0.4s ease-in-out;
            border-radius: 16px;
            padding: 14px 22px;
            font-weight: 700;
            color: #454233;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .btn-primary:hover {
            background-color: #ded7bfff;
            transform: translateY(-2px);
            color: #454233;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.4);
        }

        .modal-content {
            border-radius: 20px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
        }

        .modal-header {
            background-color: #454233;
            color: white;
            border-bottom: none;
            padding: 15px 20px;
            border-radius: 18px 18px 0px 0px;
        }

        .modal-footer {
            padding: 15px 20px;
            border-top: none;
        }
    </style>

    <button type='button' class='btn btn-primary' data-bs-toggle='modal' data-bs-target='#<?= $id ?>'>
        Suscribirse
    </button>

    <div class='modal fade' id='<?= $id ?>' data-bs-backdrop='static' data-bs-keyboard='false' tabindex='-1' aria-labelledby='<?= $id ?>Label' aria-hidden='true'>
        <div class='modal-dialog modal-dialog-centered modal-xl'>
            <div class='modal-content'>
                <div class='modal-header'>
                    <h1 class='modal-title fs-5' id='<?= $id ?>Label'><?= $title ?></h1>
                    <button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'></button>
                </div>
                <div class='modal-body'>
                    <form class="row g-3 needs-validation" action="datos_form.php" method="post">
                        <div class="col-md-4">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" required>
                            <div class="valid-feedback">Todo correcto!</div>
                        </div>

                        <div class="col-md-4">
                            <label for="apellidos" class="form-label">Apellidos</label>
                            <input type="text" class="form-control" id="apellidos" name="apellidos" required>
                            <div class="valid-feedback">Todo correcto!</div>
                        </div>

                        <div class="col-md-4">
                            <label for="usuario" class="form-label">Usuario</label>
                            <div class="input-group has-validation">
                                <span class="input-group-text" id="inputGroupPrepend">@</span>
                                <input type="text" class="form-control" id="usuario" name="usuario" aria-describedby="inputGroupPrepend" required>
                                <div class="invalid-feedback">Elige un nombre de usuario.</div>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <label for="correo" class="form-label">Correo electrónico</label>
                            <input type="email" class="form-control" id="correo" name="correo" required>
                            <div class="invalid-feedback">Proporciona un correo válido.</div>
                        </div>

                        <div class="col-md-3">
                            <label for="plan" class="form-label">Plan</label>
                            <select class="form-select" id="plan" name="plan" required>
                                <option selected disabled value="">Selecciona un plan</option>
                                <option value="Semanal - 5,99€">Semanal - 5,99€</option>
                                <option value="Mensual - 17,99€">Mensual - 17,99€</option>
                                <option value="Anual - 69,99€">Anual - 69,99€</option>
                            </select>
                            <div class="invalid-feedback">Selecciona un plan válido.</div>
                        </div>

                        <div class="col-md-3">
                            <label class="form-label">Publicaciones</label>

                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="publicaciones[]" value="National Geographic" id="pub1">
                                <label class="form-check-label" for="pub1">National Geographic</label>
                            </div>

                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="publicaciones[]" value="Electronic Letters" id="pub2">
                                <label class="form-check-label" for="pub2">Electronic Letters</label>
                            </div>

                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="publicaciones[]" value="Conocer" id="pub3">
                                <label class="form-check-label" for="pub3">Conocer</label>
                            </div>

                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="publicaciones[]" value="Science" id="pub4">
                                <label class="form-check-label" for="pub4">Science</label>
                            </div>

                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="publicaciones[]" value="Desarrollo Web" id="pub5">
                                <label class="form-check-label" for="pub5">Desarrollo Web</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="recibir_info" value="si" id="recibir_info">
                                <label class="form-check-label" for="recibir_info">
                                    ¿Desea recibir información sobre las publicaciones?
                                </label>
                            </div>
                        </div>

                        <div class="col-12">
                            <button class="btn btn-primary" type="submit">Completar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
<?php
    return ob_get_clean();
}
?>