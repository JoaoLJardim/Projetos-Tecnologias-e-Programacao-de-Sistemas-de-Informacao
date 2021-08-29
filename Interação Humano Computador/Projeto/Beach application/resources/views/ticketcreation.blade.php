@extends('layouts.app')

@section('content')

    <h3 style="text-align: center">Criar Ticket</h3>
    <br><br>
    <div class="d-flex justify-content-center">
        <form action="/tickets/store" method="POST" enctype="multipart/form-data" style="width: 70%">
            @csrf
            <div class="form-group">
                <label for="data">Data:</label>
                <input name="data" value="{{date($now)}}" class="form-control" type="date" id="data" required>
                <small id="dataHelp" class="form-text text-muted">A data onde deseja este ticket seja Valido</small>
            </div>
            <br>
            <div class="form-group">
                <label for="espreguicadeira">Espreguiçadeira: </label>
                <input name="espreguicadeira" type="number" class="form-control" value="0" id="espreguicadeira" required>
                <small id="dataHelp" class="form-text text-muted">Cada Espreguiçadeira custa 2 EUR.</small>
            </div>
            <div class="form-group">
                <label for="chapeus">Guarda-Sol: </label>
                <input name="chapeus" type="number" class="form-control" value="0" id="chapeus" required>
                <small id="dataHelp" class="form-text text-muted">Cada Guarda-Sol custa 1.50 EUR.</small>
            </div>
            <div class="form-group">
                <label for="duche">Duche: </label>
                <input name="duche" type="number" class="form-control" value="0" id="duche" required>
                <small id="dataHelp" class="form-text text-muted">Cada Duche custa 1 EUR.</small>
            </div>
            <br>
            <input type="submit" class="btn btn-success" value="Criar Ticket">
            <a href="{{ route('tickets.showAll') }}" class="btn btn-danger">Cancelar</a>
        </form>
    </div>
@endsection
