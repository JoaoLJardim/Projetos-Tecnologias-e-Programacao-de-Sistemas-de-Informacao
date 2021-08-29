@extends('layouts.app')

@section('content')
    <h3 style="text-align: center">Editar Ticket do dia {{ $ticket->data }}</h3>
    <br><br>
    <div class="d-flex justify-content-center">
        <form action="{{ route('tickets.store.edit') }}" method="POST" class="form" enctype="multipart/form-data"
            style="width: 70%">
            @csrf
            <input type="text" value="{{ $ticket->id }}" id="id" name="id" hidden>
            @if (auth()->user()->IsAdmin)
                <div class="form-group">
                    <label for="data">Data:</label>
                    <input name="data" value="{{ date($ticket->data) }}" class="form-control" type="date" id="data"
                        required>
                    <small id="dataHelp" class="form-text text-muted">A data onde deseja este ticket seja Valido</small>
                </div>
                <div class="form-group">
                    <label for="espreguicadeira">Espreguiçadeira: </label>
                    <input name="espreguicadeira" value="{{ $ticket->espreguicadeiras }}" type="number" class="form-control"
                        id="espreguicadeira">
                    <small id="dataHelp" class="form-text text-muted">Cada Espreguiçadeira custa 2 EUR.</small>
                </div>
                <div class="form-group">
                    <label for="chapeus">Guarda-Sol: </label>
                    <input name="chapeus" value="{{ $ticket->chapeus }}" type="number" class="form-control" id="chapeus">
                    <small id="dataHelp" class="form-text text-muted">Cada Guarda-Sol custa 1.50 EUR.</small>
                </div>
                <div class="form-group">
                    <label for="duche">Duche: </label>
                    <input name="duche" value="{{ $ticket->duche }}" type="number" class="form-control" id="duche">
                    <small id="dataHelp" class="form-text text-muted">Cada Duche custa 1 EUR.</small>
                </div>
            @else
                <input name="data" value="{{ date($ticket->data) }}" class="form-control" type="date" id="data" hidden>
                <input name="espreguicadeira" value="{{ $ticket->espreguicadeiras }}" type="number" class="form-control"
                    id="espreguicadeira" hidden>
                <input name="chapeus" value="{{ $ticket->chapeus }}" type="number" class="form-control" id="chapeus" hidden>
                <input name="duche" value="{{ $ticket->duche }}" type="number" class="form-control" id="duche" hidden>
            @endif
            <div class="form-group">
                <label for="status">Estado: </label>
                <select name="status" id="duche" class="form-control">
                    @if ($ticket->estado === 'Por Pagar')
                        <option value="Por Pagar" selected>Por Pagar</option>
                        <option value="Pago">Pago</option>

                    @else
                        <option value="Por Pagar">Por Pagar</option>
                        <option value="Pago" selected>Pago</option>
                    @endif
                </select>
            </div>
            <br>
            <input type="submit" class="btn btn-success" value="Editar Ticket">
            <a href="{{ route('tickets.showAll') }}" class="btn btn-danger">Cancelar</a>
        </form>
    </div>
@endsection
