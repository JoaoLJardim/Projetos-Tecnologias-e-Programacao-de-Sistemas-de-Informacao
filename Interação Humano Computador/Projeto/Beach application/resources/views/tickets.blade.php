@extends('layouts.app')

@section('content')
    <div class="d-flex justify-content-center">
        <a href="{{ route('tickets.create') }}" class="btn btn-primary">Buy Ticket</a>
        <br>
        <br>
    </div>
    <div class="d-flex justify-content-center">
        <table id="example" class="table table-striped table-bordered" style="width:100%">
            <thead>
                <tr>
                    <th>Número Ticket</th>
                    <th>Nome Client</th>
                    <th>Número Espreguiçadeiras</th>
                    <th>Número Guarda-Sois</th>
                    <th>Número Duche</th>
                    <th>Estado</th>
                    <th>Data</th>
                    <th>Preço</th>
                    <th style="text-align: center">Açoes</th>
                </tr>
            </thead>
            <tbody>
                @foreach ($tickets as $ticket)
                    @if (auth()->user()->IsAdmin || auth()->user()->IsFuncionario)
                        <tr>
                            <td>{{ $ticket->id }}</td>
                            <td>{{ $ticket->user->name }}</td>
                            <td>{{ $ticket->espreguicadeiras }}</td>
                            <td>{{ $ticket->chapeus }}</td>
                            <td>{{ $ticket->duche }}</td>
                            <td>{{ $ticket->estado }}</td>
                            <td>{{ $ticket->data }}</td>
                            <td>{{ $ticket->preco }}</td>
                            <td>
                                @if ($ticket->estado == 'Por Pagar')
                                    <a href="{{ route('paypal.pay', $ticket->id) }}" class="btn btn-success">Pagar Por
                                        Paypal</a>
                                @endif
                                <a type="button" href="{{ route('tickets.show', $ticket->id) }}"
                                    class="btn btn-primary">More Information</a>

                                <a type="button" href="{{ route('tickets.edit', $ticket->id) }}"
                                    class="btn btn-warning">Edit</a>
                            </td>
                        </tr>
                    @else
                        @if (auth()->user()->id == $ticket->created_by)
                            <tr>
                                <td>{{ $ticket->id }}</td>
                                <td>{{ $ticket->user->name }}</td>
                                <td>{{ $ticket->espreguicadeiras }}</td>
                                <td>{{ $ticket->chapeus }}</td>
                                <td>{{ $ticket->duche }}</td>
                                <td>{{ $ticket->estado }}</td>
                                <td>{{ $ticket->data }}</td>
                                <td>{{ $ticket->preco }}</td>
                                <td>
                                    @if ($ticket->estado == 'Por Pagar')
                                        <a href="{{ route('paypal.pay', $ticket->id) }}" class="btn btn-success">Pagar Por
                                            Paypal</a>
                                    @endif
                                    <a type="button" href="{{ route('tickets.show', $ticket->id) }}"
                                        class="btn btn-primary">Detalhes</a>
                                </td>
                            </tr>
                        @endif
                    @endif
                @endforeach
            </tbody>
        </table>
    </div>
@endsection
