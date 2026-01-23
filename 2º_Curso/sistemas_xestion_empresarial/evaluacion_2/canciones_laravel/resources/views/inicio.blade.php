@extends('principal')

@section('titulo', 'Todas las canciones')

@section('contenido')

@if(session('mensaje'))
    <div class="alert alert-success">
        {{ session('mensaje') }}
    </div>
@endif

<h1>Todas las canciones</h1>

@if($canciones->count() > 0)
<div class="table-container">
    <table>
        <thead>
            <tr>
                <th>Título</th>
                <th>Álbum</th>
                <th>Grupo</th>
                <th>Publicación</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            @foreach ($canciones as $cancion)
                <tr>
                    <td>{{ $cancion->titulo }}</td>
                    <td>{{ $cancion->album }}</td>
                    <td>{{ $cancion->grupo }}</td>
                    <td>{{ $cancion->publicacion }}</td>
                    <td class="action-buttons">
                        <a href="{{ route('editarCancion', $cancion->id) }}" class="btn btn-edit">Editar</a>
                        <a href="{{ route('eliminarCancion', $cancion->id) }}" class="btn btn-delete">Borrar</a>
                    </td>
                </tr>
            @endforeach
        </tbody>
    </table>
</div>
@else
<div class="empty-state">
    <p>No hay canciones registradas.</p>
</div>
@endif
@endsection