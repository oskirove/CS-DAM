<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Cancion;

class CancionController extends Controller
{
    public function index()
    {
        $canciones = Cancion::all();
        return view('inicio', ['canciones' => $canciones]);
    }

    public function agregarCancion(Request $peticion)
    {
        $cancion = new Cancion();
        $cancion->titulo = $peticion->titulo;
        $cancion->album = $peticion->album;
        $cancion->grupo = $peticion->grupo;
        $cancion->publicacion = $peticion->publicacion;
        $cancion->save();
        session()->flash('mensaje','Canción agregada correctamente');
        return redirect()->route('inicio');
    }

    public function eliminarCancion(Request $peticion)
    {
        $idEliminar = $peticion->route("id");
        $cancion = Cancion::findOrFail($idEliminar);
        $cancion->delete();
        session()->flash('mensaje','Canción eliminada correctamente');
        return redirect()->route('inicio');
    }

    public function editarCancion(Request $peticion)
    {
        $idEditar = $peticion->route("id");
        $cancion = Cancion::findOrFail($idEditar);
        return view('editar_cancion', ['cancion' => $cancion]);
    }

    public function actualizarCancion(Request $peticion)
    {
        $idActualizar = $peticion->route("id");
        $cancion = Cancion::findOrFail($idActualizar);
        $cancion->titulo = $peticion->titulo;
        $cancion->album = $peticion->album;
        $cancion->grupo = $peticion->grupo;
        $cancion->publicacion = $peticion->publicacion;
        $cancion->save();
        session()->flash('mensaje','Canción actualizada correctamente');
        return redirect()->route('inicio');
    }
}
