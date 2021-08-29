@extends('layouts.app')

@section('content')

<h1 class="title">Stand Automovel</h1>

    <div class="intro">

        <img src="/img/stand.jpg" alt="loja/img">
        <br>
    <a href="{{route('cars.index')}}">Ver Carros</a>
    </div>
@endsection
