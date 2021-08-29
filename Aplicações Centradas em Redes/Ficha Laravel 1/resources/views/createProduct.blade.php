@extends('layouts.app')

@section('content')
    <h1>Loaj de Informática - Criar Produto</h1>
    <div class="detalhes">
    <p class="message">{{session('mssg')}}</p>
    <div class="error">
        <ul>
            @foreach ($errors->all() as $error)
        <li>{{$error}}</li>
            @endforeach
        </ul>
    </div>
    <form action="{{route('products.store')}}" method="POST" enctype="multipart/form-data">
    @csrf
    <label for="name">Nome do Produto:</label>
    <input type="text" id="name" name="name">
    <br>
    <label for="desc">Descrição do Produto:</label>
    <input type="text" name="desc" id="desc">
    <br>
    <label for="url">Imagem:</label>
    <input type="file" name="url" id="url">
    <br>
    <label for="price">Preço:</label>
    <input type="text" name="price" id="price">
    <br>
    <label for="tipoProduto">Tipo de Produto:</label>
    <select name="tipoProduto" id="tipoProduto">
        @foreach ($tipos as $tipo)
            <option value="{{$tipo->id}}">{{$tipo->name}}</option>        
        @endforeach
    </select>
    <br>
    <input type="submit" value="Criar Produto">
    </form>
    <a href="/produtos">Voltar aos Produtos</a>
    </div>
@endsection