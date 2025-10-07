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
                    <form class="row g-3 needs-validation" novalidate>
                        <div class="col-md-4">
                            <label for="validationCustom01" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="validationCustom01" value="Claude" required>
                            <div class="valid-feedback">
                                Todo correcto!
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label for="validationCustom02" class="form-label">Apellido</label>
                            <input type="text" class="form-control" id="validationCustom02" value="Monet" required>
                            <div class="valid-feedback">
                                Todo correcto!
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label for="validationCustomUsername" class="form-label">Usuario</label>
                            <div class="input-group has-validation">
                                <span class="input-group-text" id="inputGroupPrepend">@</span>
                                <input type="text" class="form-control" id="validationCustomUsername" aria-describedby="inputGroupPrepend" required>
                                <div class="invalid-feedback">
                                    Elige un nombre de usuario.
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label for="validationCustom03" class="form-label">Correo electrónico</label>
                            <input type="email" class="form-control" id="validationCustom03" required>
                            <div class="invalid-feedback">
                                Proporciona un correo válido.
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label for="validationCustom04" class="form-label">State</label>
                            <select class="form-select" id="validationCustom04" required>
                                <option selected disabled value="">Subscripción</option>
                                <option>Semanal - 5,99€</option>
                                <option>Mensual - 17,99€</option>
                                <option>Anual - 69,99€</option>
                            </select>
                            <div class="invalid-feedback">
                                Please select a valid state.
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label for="validationCustom05" class="form-label">Publicaciones</label>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="checkDefault" checked>
                                <label class="form-check-label" for="checkDefault">
                                    National Geographic
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="checkChecked">
                                <label class="form-check-label" for="checkChecked">
                                    Electronic Letters
                                </label>
                            </div>
                             <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="checkChecked">
                                <label class="form-check-label" for="checkChecked">
                                    Conocer
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="checkChecked">
                                <label class="form-check-label" for="checkChecked">
                                    Science
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="checkChecked">
                                <label class="form-check-label" for="checkChecked">
                                    Desarrollo Web
                                </label>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                                <label class="form-check-label" for="invalidCheck">
                                    ¿Desea recibir información sobre las publicaciones?
                                </label>
                                <div class="invalid-feedback">
                                    You must agree before submitting.
                                </div>
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
