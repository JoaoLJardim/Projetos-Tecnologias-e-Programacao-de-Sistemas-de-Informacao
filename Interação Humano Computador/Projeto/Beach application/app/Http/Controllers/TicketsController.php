<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Ticket;
use DateTime;
use Illuminate\Support\Facades\Date;

class TicketsController extends Controller
{


    #
    # Author: João Luís Gomes Jardim
    # Routes for Tickets
    #

    public function showTickets() {
        $tickets = Ticket::all();

        return view("tickets", ['tickets' => $tickets]);
    }

    public function showTicket($id) {
        $ticket = Ticket::findOrFail($id);;

        if (auth()->user()->id == $ticket->created_by) {
            return view("ticket", ['ticket' => $ticket]);
        }

        if (!auth()->user()->IsAdmin && !auth()->user()->IsFuncionario) {
            return redirect('/tickets')->with("error", "Não tem Permissão para visualizar tickets de outros usuarios");
        }

        return view("ticket", ['ticket' => $ticket]);
    }

    public function createTicket() {
        $now = date("Y-m-d");
    
        return view("ticketcreation",['now' => $now] );
    }

    public function editTicket($id) {
        if (!auth()->user()->IsAdmin && !auth()->user()->IsFuncionario) {
            return redirect('/tickets')->with("error", "Não tem Permissão para Editar os Tickets, caso Queira adicionar mais cadeiras, crie um novo ticket ");
        }

        $ticket = Ticket::findOrFail($id);;

        return view("editTicket",['ticket' => $ticket]);
    }

    public function ticketStore(Request $request) {
        $data = request('data');
        $espreguicadeiras =  request('espreguicadeira');
        $chapeus = request('chapeus');
        $duches = request('duche');

        $preco = 0;

        $preco+= $espreguicadeiras * 2;
        $preco+= $chapeus * 1.5;
        $preco+= $duches;

        $date = new DateTime($data."T18:00:00.012345Z");
        $now = new DateTime();

        if($date < $now) {
            return redirect('/tickets/create')->with("error", "A data inserida ja passo da validade ");
        }

        if ($preco == 0) {
            return redirect('/tickets/create')->with("error", "Não especifico nenhum tipo de material");
        }

        $ticketCreated = new Ticket();
        $ticketCreated->data = $data;
        $ticketCreated->espreguicadeiras =  $espreguicadeiras;
        $ticketCreated->chapeus = $chapeus;
        $ticketCreated->duche = $duches;
        $ticketCreated->estado = "Por Pagar";
        $ticketCreated->preco = $preco;
        $ticketCreated->created_by = auth()->user()->id;

        $ticketCreated->save();

        return redirect('/tickets')->with("success", "Ticket criado com sucesso");
    }

    public function ticketStoreEdit(Request $request) {
        if (!auth()->user()->IsAdmin && !auth()->user()->IsFuncionario) {
            return redirect('/tickets')->with("error", "Não tem Permissão para Editar os Tickets, caso Queira adicionar mais cadeiras, crie um novo ticket ");
        }
        
        $data = request('data');
        $espreguicadeiras =  request('espreguicadeira');
        $chapeus = request('chapeus');
        $duches = request('duche');
        $estado = request('status');
        $id = request('id');

        $preco = 0;

        $preco+= $espreguicadeiras * 2;
        $preco+= $chapeus * 1.5;
        $preco+= $duches;

        if ($preco == 0) {
            return redirect('/tickets/create')->with("error", "Não especifico nenhum tipo de material");
        }

        $ticketEdited = Ticket::findOrFail($id);
        $ticketEdited->data = $data;
        $ticketEdited->espreguicadeiras =  $espreguicadeiras;
        $ticketEdited->chapeus = $chapeus;
        $ticketEdited->duche = $duches;
        $ticketEdited->estado = $estado;
        $ticketEdited->preco = $preco;

        $ticketEdited->save();

        return redirect(route('tickets.edit',$id))->with("success", "Ticket Editado com sucesso");
    }
}
