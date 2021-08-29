@extends('layouts.app')

@section('content')
    <h3 style="text-align: center">Informações do Ticket do dia {{ $ticket->data }}</h3>
    <br>
    <div class="d-flex justify-content-center">
        <form class="form" style="width: 70%">
            @csrf
            <input type="text" value="{{ $ticket->id }}" id="id" name="id" hidden>
            <div class="form-group">
                <label for="data">Data:</label>
                <input name="data" value="{{ date($ticket->data) }}" class="form-control" type="date" id="data" required
                    readonly>
                <small id="dataHelp" class="form-text text-muted">A data onde deseja este ticket seja Valido</small>
            </div>
            <br>
            <div class="form-group">
                <label for="espreguicadeira">Espreguiçadeira: </label>
                <input name="espreguicadeira" value="{{ $ticket->espreguicadeiras }}" type="number" class="form-control"
                    id="espreguicadeira" readonly>
                <small id="dataHelp" class="form-text text-muted">Cada Espreguiçadeira custa 2 EUR.</small>
            </div>
            <div class="form-group">
                <label for="chapeus">Guarda-Sol: </label>
                <input name="chapeus" value="{{ $ticket->chapeus }}" type="number" class="form-control" id="chapeus"
                    readonly>
                <small id="dataHelp" class="form-text text-muted">Cada Guarda-Sol custa 1.50 EUR.</small>
            </div>
            <div class="form-group">
                <label for="duche">Duche: </label>
                <input name="duche" value="{{ $ticket->duche }}" type="number" class="form-control" id="duche" readonly>
                <small id="dataHelp" class="form-text text-muted">Cada Duche custa 1 EUR.</small>
            </div>
            <div class="form-group">
                <label for="duche">Total:</label>
                <input name="duche" value="{{ $ticket->preco }}" type="number" class="form-control" id="duche" readonly>
                <small id="dataHelp" class="form-text text-muted">Total.</small>
            </div>

            <div class="form-group">
                <label for="status">Estado: </label>
                <input name="duche" value="{{ $ticket->estado }}" type="text" class="form-control" id="duche" readonly>
            </div>
            <br>
            <a href="{{ route('tickets.showAll') }}" class="btn btn-danger">Voltar</a>
        </form>
        <br>
    </div>
@endsection
