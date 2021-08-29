@extends('layouts.app')

@section('content')
    @auth
        <div class="d-flex justify-content-center">
            <table id="example" class="table table-striped table-bordered" style="width:100%">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Data de criação</th>
                    <th>Data Update</th>
                    <th>Tipo</th>
                    <th style="text-align: center">Ações</th>
                </tr>
            </thead>
            <tbody>
                @foreach ($utilizadores as $utilizador)
                    <tr>
                        <td>{{ $utilizador->id }}</td>
                        <td>{{ $utilizador->name }}</td>
                        <td>{{ $utilizador->email }}</td>
                        <td>{{ $utilizador->created_at }}</td>
                        <td>{{ $utilizador->updated_at }}</td>
                        @if ($utilizador->IsFuncionario == 0 && $utilizador->IsAdmin == 0)
                            <td>Cliente</td>
                        @endif
                        @if ($utilizador->IsFuncionario == 1 && $utilizador->IsAdmin == 0)
                            <td>Funcionario</td>
                        @endif
                        @if ($utilizador->IsFuncionario == 0 && $utilizador->IsAdmin == 1)
                            <td>Admin</td>
                        @endif
                        @if (($utilizador->IsFuncionario == 0 && $utilizador->IsAdmin == 0) || ($utilizador->IsFuncionario == 1 && $utilizador->IsAdmin == 0))
                            <td style="display: flex;">
                                <form action="{{ route('utilizador.destroy', $utilizador->id) }}" method="post">
                                    @csrf
                                    @method('DELETE')
                                    <button class="btn btn-danger" style="margin: 10px">Eliminar </button>
                                </form>
                                <form action="{{ route('utilizador.edit', $utilizador->id) }}" method="GET">
                                    @csrf
                                    <button class="btn btn-warning" style="margin: 10px">Editar </button>
                                </form>
                                <!--   <a href="{{ route('utilizador.edit', $utilizador->id) }}">Editar</a>|<a href="">Remover</a> -->
                            </td>
                        @else
                            <td>Sem ações disponiveis</td>
                        @endif
                    </tr>
                @endforeach
            </tbody>
        </table>
        </div>
    @endauth
@endsection
