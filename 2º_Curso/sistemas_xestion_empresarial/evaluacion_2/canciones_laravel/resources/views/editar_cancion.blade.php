@extends('principal')

@section('titulo', 'Editar canción')

@section('contenido')
    <h1>✏️ Editar canción</h1>

    <style>
        .form-container {
            max-width: 500px;
            margin: 0 auto;
            background: rgba(255, 255, 255, 0.03);
            backdrop-filter: blur(20px);
            border-radius: 16px;
            border: 1px solid rgba(255, 255, 255, 0.08);
            padding: 2.5rem;
            box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.4);
        }

        .form-group {
            margin-bottom: 1.5rem;
        }

        .form-label {
            display: block;
            font-size: 0.875rem;
            font-weight: 500;
            color: #c7d2fe;
            margin-bottom: 0.5rem;
            letter-spacing: 0.025em;
        }

        .form-input {
            width: 100%;
            padding: 0.875rem 1rem;
            font-size: 1rem;
            font-family: inherit;
            color: #e4e4e7;
            background: rgba(255, 255, 255, 0.05);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 10px;
            transition: all 0.3s ease;
            outline: none;
        }

        .form-input::placeholder {
            color: #71717a;
        }

        .form-input:hover {
            border-color: rgba(165, 180, 252, 0.3);
            background: rgba(255, 255, 255, 0.07);
        }

        .form-input:focus {
            border-color: #818cf8;
            background: rgba(255, 255, 255, 0.08);
            box-shadow: 0 0 0 3px rgba(129, 140, 248, 0.2);
        }

        .form-actions {
            display: flex;
            gap: 1rem;
            margin-top: 2rem;
            padding-top: 1.5rem;
            border-top: 1px solid rgba(255, 255, 255, 0.08);
        }

        .btn-primary {
            flex: 1;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            gap: 0.5rem;
            padding: 0.875rem 1.5rem;
            font-size: 0.95rem;
            font-weight: 600;
            font-family: inherit;
            color: #fff;
            background: linear-gradient(135deg, #6366f1, #8b5cf6);
            border: none;
            border-radius: 10px;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 25px rgba(99, 102, 241, 0.4);
        }

        .btn-primary:active {
            transform: translateY(0);
        }

        .btn-secondary {
            display: inline-flex;
            align-items: center;
            justify-content: center;
            gap: 0.5rem;
            padding: 0.875rem 1.5rem;
            font-size: 0.95rem;
            font-weight: 500;
            font-family: inherit;
            color: #a5b4fc;
            background: rgba(255, 255, 255, 0.05);
            border: 1px solid rgba(255, 255, 255, 0.15);
            border-radius: 10px;
            text-decoration: none;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        .btn-secondary:hover {
            background: rgba(255, 255, 255, 0.1);
            border-color: rgba(165, 180, 252, 0.3);
            color: #c7d2fe;
            transform: translateY(-2px);
        }

        .required-indicator {
            color: #f87171;
            margin-left: 0.25rem;
        }
    </style>

    <div class="form-container">
        <form action="{{ route('actualizarCancion', $cancion->id) }}" method="POST">
            @csrf
            <div class="form-group">
                <label for="titulo" class="form-label">
                    Título de la canción<span class="required-indicator">*</span>
                </label>
                <input type="text" class="form-input" id="titulo" name="titulo" value="{{ $cancion->titulo }}" required>
            </div>
            <div class="form-group">
                <label for="album" class="form-label">Álbum</label>
                <input type="text" class="form-input" id="album" name="album" value="{{ $cancion->album }}">
            </div>
            <div class="form-group">
                <label for="grupo" class="form-label">
                    Grupo<span class="required-indicator">*</span>
                </label>
                <input type="text" class="form-input" id="grupo" name="grupo" value="{{ $cancion->grupo }}" required>
            </div>
            <div class="form-group">
                <label for="publicacion" class="form-label">Año de publicación</label>
                <input type="text" class="form-input" id="publicacion" name="publicacion"
                    value="{{ $cancion->publicacion }}">
            </div>
            <div class="form-actions">
                <button type="submit" class="btn-primary">💾 Guardar cambios</button>
                <a href="{{ route('inicio') }}" class="btn-secondary">Cancelar</a>
            </div>
        </form>
    </div>

@endsection