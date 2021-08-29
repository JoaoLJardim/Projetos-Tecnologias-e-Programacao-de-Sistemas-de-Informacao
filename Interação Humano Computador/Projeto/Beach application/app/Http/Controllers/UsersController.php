<?php

namespace App\Http\Controllers;
use App\Http\Requests\EditUserRequest;
use App\Models\User;
use Illuminate\Http\Request;

class UsersController extends Controller
{
   
    public function index()
    {
        if (!auth()->user()->IsAdmin) {
            return redirect(route('index'))->with("error", "Não tem Permissão para visualizar esta pagina");
        }

        $utilizadores=User::all();
        return view('utilizadores',['utilizadores'=>$utilizadores]);
    }

    public function edit($id){  
        if (!auth()->user()->IsAdmin) {
            return redirect(route('index'))->with("error", "Não tem Permissão para visualizar esta pagina");
        }

        $utilizador=User::findOrFail($id);
        return view('editUser',['utilizador'=>$utilizador]);
    }

    public function update($id){
        if (!auth()->user()->IsAdmin) {
            return redirect(route('index'))->with("error", "Não tem Permissão para visualizar esta pagina");
        }

        $IsFuncionario=request('IsFuncionario');
        $utilizador=User::findOrFail($id);
        $utilizador->IsFuncionario=$IsFuncionario;
        $utilizador->save();

        return redirect(route('utilizador.edit', $id))->with('success','Utilizador editado com successo');
    }

    public function destroy($id){
        if (!auth()->user()->IsAdmin) {
            return redirect(route('index'))->with("error", "Não tem Permissão para visualizar esta pagina");
        }

        $livro=User::findOrFail($id);
        $livro->delete();
        return redirect('/utilizadores');
    }
}
