@extends('layouts.app')

@section('content')
<div class="form">
<h1>Portal do Aluno - Criar Aluno</h1>
    <p class="message">{{session('mssg')}}</p>
    <form action="{{route('alunos.nota.store', $id)}}"  method="POST" enctype="multipart/form-data">
        @csrf
        <label for="disciplina">Disciplina:</label>
        <input type="text" id="disciplina" name="disciplina" required>
        <br>
        <label for="professor">Professor:</label>
        <input type="text" id="professor" name="professor" required>
        <br>
        <label for="img">Nota:</label>
        <input type="text" id="nota" name="nota" required>
        <br>
        <input type="submit" value="Add Nota" class="form-submit">
    </form>
    <a href="{{route('aluno.show', $id)}}" class="link-button">Voltar ao Aluno</a>
</div>
@endsection