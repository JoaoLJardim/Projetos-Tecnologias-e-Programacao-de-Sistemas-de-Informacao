@extends('layouts.app')

@section('content')
    <div class="detalhes">
        <h1 style="text-align: center">Utilizadores -Editar utilizador</h1>
        <div class="d-flex justify-content-center">
            <form method="POST" enctype="multipart/form-data" class="form" action="{{ route('utilizador.update', $utilizador->id) }}" style="width: 70%">
                @csrf
                <div class="form-group">
                    <label for="name">Nome do Utilizador:</label>
                    <input type="text" id="name" name="name" required class="form-control" readonly="readonly" @if (isset($utilizador)) value="{{ $utilizador->name }}" @endif>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" id="email" name="email" required readonly="readonly" class="form-control" @if (isset($utilizador)) value="{{ $utilizador->email }}" @endif>
                </div>
                <div class="form-group">
                    <label for="tipo">Tipo de utilizador:</label>
                    <select name="IsFuncionario" id="IsFuncionario" class="form-control">
                        @if ($utilizador->IsFuncionario == 0 && $utilizador->IsAdmin == 0)
                            <option value="0" selected="selected">Cliente</option>
                            <option value="1">Funcionario</option>

                        @endif
                        @if ($utilizador->IsFuncionario == 1 && $utilizador->IsAdmin == 0)
                            <option value="1" selected="selected">Funcionario</option>
                            <option value="0">Cliente</option>
                        @endif



                    </select>
                </div>
                <br>
                <input type="submit" class="btn btn-success" value="Editar Utilizador">
                <a href="{{ route('utilizador.index') }}" class="btn btn-danger">Cancelar</a>
            </form>
        </div>

    </div>
@endsection
