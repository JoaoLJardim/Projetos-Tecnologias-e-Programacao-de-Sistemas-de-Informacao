@extends('layouts.app')

@section('content')
    <h1 class="title">Loja de Informática - Detalhes</h1>

    <div class="produto">
        @if (isset($produto))
    <img src="{{$produto->img}}" alt="produto/img">
    <h2>{{$produto->nome}}</h2>
    <p>{{$produto->desc}}</p>

    @else
        <h1>O Produto não existe</h1>
        @endif

        @auth
    <form action="{{route('cars.destroy',$produto->id)}}" method="POST">
        @csrf
        @method('DELETE')
        <button>Eliminar Carro</button>
    </form>
    @endauth
        <a href="{{route('cars.index')}}">Voltar aos Carros</a>
    </div>
@endsection