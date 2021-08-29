@extends('layouts.app')

@section('content')
    <div class="form" style="text-align: center">
        <form action="">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" placeholder="Seu nome aqui..."><br>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" placeholder="Email aqui..."><br>
            <label for="nome">Texto:</label>
            <textarea rows="4" cols="50" name="comment" form="usrform" placeholder="Texto aqui..."></textarea>
            <br>
            <br>
            <input type="submit" value="Enviar Email" class="form-submit">
        </form>
    </div>
@endsection
