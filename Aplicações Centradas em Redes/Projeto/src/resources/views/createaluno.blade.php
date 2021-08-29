@extends('layouts.app')

@section('content')
    <div class="form">
        <h1>Portal do Aluno - Criar Aluno</h1>
        @foreach ($errors->all() as $error)
            <p class="message-error">{{ $error }}</p>
        @endforeach
        <p class="message">{{ session('mssg') }}</p>
        <form action="/alunos" method="POST" enctype="multipart/form-data">
            @csrf
            <label for="nome">Nome do Aluno:</label>
            <input type="text" id="nome" name="nome" required placeholder="Nome do aluno..">
            <br>
            <label for="num">Numero do Aluno:</label>
            <input type="number" id="num" name="num" required placeholder="Numero do aluno..">
            <br>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required placeholder="Email do aluno..">
            <br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required placeholder="Password do aluno..">
            <br>
            <label for="img">Imagem:</label>
            <input type="file" id="img" name="img" class="file-input" required placeholder="Imagem do aluno..">
            <br>
            <label for="turma">Turma:</label>
            <select name="turma" id="turma" required>
                <option selected></option>
                @foreach ($turmas as $turma)
                    <option value="{{ $turma->id }}">{{ $turma->ano }}-{{ $turma->turma }}</option>
                @endforeach
            </select>
            <br>
            <br>
            <input type="submit" value="Criar Aluno" class="form-submit">
        </form>
        <a href="/alunos" class="link-button">Voltar Aos Alunos</a>
    </div>
@endsection
