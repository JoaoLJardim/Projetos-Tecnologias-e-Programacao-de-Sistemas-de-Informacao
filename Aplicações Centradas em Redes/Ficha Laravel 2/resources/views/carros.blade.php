@extends('layouts.app')

@section('content')
    <h1 class="title">Loja de Informática - Produtos</h1>
    <div class="listaMarcas">
        @if (!isset($actMarca))
            <b>
        @endif
            <a href="{{route('cars.index')}}">Todas as Marcas</a>
        @if (!isset($actMarca))
            </b>
        @endif
        @foreach ($marcas as $marca)
            @if (isset($actMarca) && $actMarca->id == $marca->id)
                <b>
            @endif
            - <a href="{{route('cars.by.marca',$marca->id)}}">{{$marca->nome}}</a>
            @if (isset($actMarca) && $actMarca->id == $marca->id)
                <b>
            @endif
        @endforeach
    </div>

    @foreach ($carros as $car)
    <div class="produto">
    <a href="{{route('cars.show', $car->id)}}">
    <img src="{{$car->img}}" alt="img/produto">
    <h2>{{$car->nome}}</h2>
    </a>
    </div>
    @endforeach
    <br>
    @auth
    <a href="{{route('cars.create')}}">Criar Carro</a>
    @endauth
    @endsection