@extends('layouts.app')

@section('content')
    <p class="message">{{ session('mssg') }}</p>
    <p class="message-error">{{ session('error') }}</p>
    <div class="update-btn">
        @auth
            @if (Auth::user()->isAdmin || Auth::user()->isTeacher)
                <form action="{{ route('turmas.destroy', $turma->id) }}" method="POST">
                    @csrf
                    @method('DELETE')
                    <button class="btn-delete"><img src="/img/delete.png" style="width: 30px" alt=""></button>
                </form>
                <a href="{{ route('turma.edit', $turma->id) }}" class="link-button"><img src="/img/update.png" style="width: 30px" alt=""></a>
            @endif
        @endauth
    </div>

    <h2 style="text-align: center">Turma - {{ $turma->ano }}-{{ $turma->turma }}</h2>
    <br>
    <br>
    <h5 style="text-align: center">Alunos - {{ count($alunos) }}</h5>
    <table>
        <tr>
            <th>Nome</th>
            <th>Imagem</th>
            <th>Mais Detalhes</th>
        </tr>
        @foreach ($alunos as $aluno)
            <tr>
                <td>{{ $aluno->nome }}</td>
                <td><img src="{{ $aluno->img }}" alt="" class="aluno-img"></td>
                <td><a class="aluno" href="{{ route('aluno.show', $aluno->id) }}" class="link-button"><img
                            src="public/img/detalhes.png" style="width: 50px" alt=""><img src="/img/detalhes.png"
                            style="width: 50px" alt=""></a></td>
            </tr>
        @endforeach
    </table>
@endsection
