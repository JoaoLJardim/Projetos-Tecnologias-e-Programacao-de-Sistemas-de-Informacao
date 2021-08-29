@extends('layouts.app')

@section('content')
    <h1>Loja de Informática - Detalhes</h1>

    <div class="detalhes">
        @if (isset($produto))
    <img src="{{$produto->url}}" alt="produto/img">

    <h2>{{$produto->nome}}</h2>
    <p>{{$produto->desc}}
    € {{$produto->preco}}</p>
            
    @else
        <h1>O Produto não existe</h1>
    @endif

    @auth
    <form action="{{route('products.destroy',$produto->id)}}" method="POST">
    @csrf
    @method('DELETE')
    <button>Eliminar Produto</button>
    </form>
    @endauth
        <a href="{{route('products.index')}}">Voltar aos produtos</a>
    </div>
@endsection