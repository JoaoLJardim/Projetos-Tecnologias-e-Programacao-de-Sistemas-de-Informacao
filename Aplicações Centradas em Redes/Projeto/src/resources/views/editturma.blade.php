@extends('layouts.app')

@section('content')
    <div class="form">
        <h1>Portal do Aluno - Editar Turma</h1>
        @foreach ($errors->all() as $error)
            <p class="message-error">{{ $error }}</p>
        @endforeach
        <p class="message">{{ session('mssg') }}</p>
        <form action="/turmas/edit" method="POST" enctype="multipart/form-data">
            @csrf
            <input type="text" value="{{ $turma->id }}" id="id" name="id" hidden>
            <label for="ano">Ano Escolar:</label>
            <input type="text" id="ano" name="ano" required value="{{ $turma->ano }}">
            <br>
            <label for="turma">Turma:</label>
            <input type="text" id="turma" name="turma" required value="{{ $turma->turma }}">
            <br>

            <input type="submit" value="Editar Turma" class="form-submit">

        </form>
        <a href="{{ route('turma.show', $turma->id) }}" class="link-button">Voltar a Turma</a>
    </div>
@endsection
