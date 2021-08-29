@extends('layouts.app')

@section('content')
    <div class="form">
        <h1>Portal do Aluno - Editar Aluno</h1>
        @foreach ($errors->all() as $error)
            <p class="message-error">{{ $error }}</p>
        @endforeach
        <p class="message">{{ session('mssg') }}</p>
        <form action="/alunos/edit" method="POST" enctype="multipart/form-data">
            @csrf
            <input type="text" value="{{ $aluno->id }}" id="id" name="id" hidden>
            <label for="nome">Nome do Aluno:</label>
            <input type="text" id="nome" name="nome" required value="{{ $aluno->nome }}" placeholder="Nome do aluno..">
            <br>
            @if (auth()->user()->isAdmin || auth()->user()->isTeacher)
                <label for="num">Numero do Aluno:</label>
                <input type="number" id="num" name="num" required value="{{ $aluno->num }}" placeholder="Numero do aluno..">
                <br>
            @endif
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required value="{{ $aluno->email }}" placeholder="Email do aluno..">
            <br>
            <label for="img">Imagem:</label>
            <input type="file" id="img" name="img" value="{{ $aluno->nome }}" placeholder="Imagem do aluno..">
            <br>
            @if (auth()->user()->isAdmin || auth()->user()->isTeacher)
                <label for="turma">Turma:</label>
                <select name="turma" id="turma" required>
                    @foreach ($turmas as $turma)
                        <option value="{{ $turma->id }}" @if ($turma->id == $aluno->turma_id)
                            selected="selected"
                    @endif >{{ $turma->ano }}-{{ $turma->turma }}</option>
            @endforeach
            </select>
            @endif
            <br>
            <br>
            <input type="submit" value="Atualizar Aluno" class="form-submit">
        </form>
        <a href="{{ route('aluno.show', $aluno->id) }}" class="link-button">Voltar ao Aluno</a>
    </ @endsection
