@extends('layouts.app')

@section('content')
    <h1 class="title">Loja de Informática - Criar Carro</h1>

    <div class="detalhes">
    <p class="message">{{session('mssg')}}</p>
    <div class="error">
        <ul>
            @foreach ($errors->all() as $error)
        <li>{{$error}}</li>
            @endforeach
        </ul>
    </div>
    <form action="{{route('cars.store')}}" method="POST" enctype="multipart/form-data">
        @csrf
        <label for="name">Nome do Carro</label>
        <input type="text" name="name" id="name">
        <br>
        <label for="desc">Descrição do carro</label>
        <input type="text" name="desc" id="desc">
        <br>
        <label for="img">Imagem:</label>
        <input type="file" name="img" id="img">
        <br>
        <label for="marca">Marca:</label>
        <select name="marca" id="marca">
            @foreach ($marcas as $marca)
                <option value="{{$marca->id}}">{{$marca->nome}}</option>
            @endforeach
        </select>
        <br>
        <input type="submit" value="Criar Carro">
    </form>
    <a href="{{route('cars.index')}}">Voltar Aos Carros</a>
    </div>
@endsection