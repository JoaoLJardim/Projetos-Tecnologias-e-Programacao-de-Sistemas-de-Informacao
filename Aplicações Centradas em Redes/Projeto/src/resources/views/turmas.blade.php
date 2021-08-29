@extends('layouts.app')

@section('content')

    @auth
        @if (Auth::user()->isAdmin || Auth::user()->isTeacher)
            <a style="" href="{{ route('turmas.create') }}" class="link-button"><img src="img/add.png" style="width: 30px"alt=""></a>
        @endif

    @endauth
    <table>
        <tr>
            <th>Ano</th>
            <th>Turma</th>
            <th>Mais Detalhes</th>
        </tr>
        @foreach ($turmas as $turma)
            <tr>
                <td>{{ $turma->ano }}</td>
                <td> {{$turma->turma}}</td>
                <td><a class="aluno" href="{{ route('turma.show', $turma->id) }}" class="link-button"><img src="/img/detalhes.png" style="width: 50px" alt=""></a></td>
            </tr>
        @endforeach
    </table>
@endsection
