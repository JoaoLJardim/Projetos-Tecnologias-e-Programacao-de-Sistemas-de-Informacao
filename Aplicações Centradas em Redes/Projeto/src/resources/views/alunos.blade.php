@extends('layouts.app')

@section('content')

    @auth
        @if (Auth::user()->isAdmin || Auth::user()->isTeacher)
            <a style="" href="{{ route('alunos.create') }}" class="link-button"><img src="img/add.png" style="width: 30px" alt=""></a>
        @endif
    @endauth
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
                <td><a class="aluno" href="{{ route('aluno.show', $aluno->id) }}" class="link-button"><img src="/img/detalhes.png" style="width: 50px" alt=""></a></td>
            </tr>
        @endforeach
    </table>
@endsection
