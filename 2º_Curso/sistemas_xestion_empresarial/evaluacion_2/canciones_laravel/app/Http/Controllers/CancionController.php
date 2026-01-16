<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Cancion;

class CancionController extends Controller
{
    //
    public function index()
    {
        $canciones = Cancion::all();
        return view('inicio', ['canciones' => $canciones]);
    }
}
