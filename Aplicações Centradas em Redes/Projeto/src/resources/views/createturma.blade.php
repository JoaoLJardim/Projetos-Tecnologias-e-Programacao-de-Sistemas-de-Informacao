@extends('layouts.app')

@section('content')
    <div class="form">
        <h1>Portal do Aluno - Criar Turma</h1>
        @foreach ($errors->all() as $error)
            <p class="message-error">{{ $error }}</p>
        @endforeach
        <p class="message">{{ session('mssg') }}</p>
        <form action="/turmas" method="POST" enctype="multipart/form-data">
            @csrf
            <label for="ano">Ano Escolar:</label>
            <input type="text" id="ano" name="ano" required placeholder="Ano da turma ...">
            <br>
            <label for="turma">Turma:</label>
            <input type="text" id="turma" name="turma" required placeholder="Numero ou Letra da Turma...">
            <br>
            <input type="submit" value="Criar Turma" class="form-submit">
        </form>
        <a href="/turmas" class="link-button">Voltar as Turmas</a>
    </div>
@endsection
