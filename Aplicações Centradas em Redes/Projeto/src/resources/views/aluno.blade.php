@extends('layouts.app')

@section('content')
    <div class="aluno">
        @auth
            <div class="update-btn">
                @if (Auth::user()->isAdmin || (Auth::user()->isTeacher && $aluno->created_by == Auth::user()->id))
                    <form action="{{ route('alunos.destroy', $aluno->id) }}" method="POST">
                        @csrf
                        @method('DELETE')
                        <button class="btn-delete"><img src="/img/delete.png" style="width: 30px" alt=""></button>
                    </form>
                    <br>
                    <a href="{{ route('aluno.edit', $aluno->id) }}" class="link-button"><img src="/img/update.png"
                            style="width: 30px" alt=""></a>
                @endif
            </div>
        @endauth


        <p class="message">{{ session('mssg') }}</p>
        @foreach ($errors as $error)
            <p class="message">{{ $error }}</p>
        @endforeach
        <img src="{{ $aluno->img }}" style="width: 250px;" alt="">
        <br>
        <br>
        <h2>{{ $aluno->nome }}</h2>
        <br>
        <h4>Numero de aluno: {{ $aluno->num }}</h4>
        <br>
        @auth
            @if (Auth::user()->isAdmin || (Auth::user()->isTeacher && $aluno->created_by == Auth::user()->id))
                <br>
                <br>
                <a href="{{ route('aluno.add.nota', $aluno->id) }}" class="link-button"><img src="/img/add.png"
                        style="width: 30px" alt=""></a>
                <table>
                    <tr>
                        <th>Disciplina</th>
                        <th>Professor</th>
                        <th>Nota Final</th>
                    </tr>
                    @foreach ($notas as $nota)
                        <tr>
                            <td>{{ $nota->disciplina }}</td>
                            <td>{{ $nota->professor }}</td>
                            <td>{{ $nota->nota }}</td>
                        </tr>
                    @endforeach
                </table>

            @else
                @if (Auth::user()->aluno_id == $aluno->id)
                    <table>
                        <tr>
                            <th>Disciplina</th>
                            <th>Professor</th>
                            <th>Nota Final</th>
                        </tr>
                        @foreach ($notas as $nota)
                            <tr>
                                <td>{{ $nota->disciplina }}</td>
                                <td>{{ $nota->professor }}</td>
                                <td>{{ $nota->nota }}</td>
                            </tr>
                        @endforeach
                    </table>
                @endif
            @endif
        @endauth
    </div>
@endsection
