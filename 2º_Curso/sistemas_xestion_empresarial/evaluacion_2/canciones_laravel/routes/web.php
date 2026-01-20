<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\CancionController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

// Route::get('/', function () {
//     return view('welcome');
// });

Route::get("/", [CancionController::class, 'index'])->name("inicio");
Route::view("/agregar", "nueva_cancion")->name("formAgregar");
Route::post("/agregar", [CancionController::class, "agregarCancion"])->name("agregarCancion");
Route::get("/eliminar/{id}", [CancionController::class, "eliminarCancion"])->name("eliminarCancion");
Route::get("/editar/{id}", [CancionController::class, "editarCancion"])->name("editarCancion");
Route::post("/editar/{id}", [CancionController::class, "actualizarCancion"])->name("actualizarCancion");