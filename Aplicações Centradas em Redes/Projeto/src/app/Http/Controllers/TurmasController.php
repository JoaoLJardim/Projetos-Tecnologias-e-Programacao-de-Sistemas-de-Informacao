<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Aluno;
use App\Models\Turma;
use Illuminate\Database\QueryException;

class TurmasController extends Controller
{
    public function showTurmas() {
        $turmas = Turma::all();

        return view("turmas", ['turmas' => $turmas]);
    }

    public function showTurma($id) {
        $turma = Turma::findOrFail($id);
        $alunosTurma = Aluno::where('turma_id', $id)->get();
        
        return view("turma", ['turma' => $turma, 'alunos' => $alunosTurma]);
    }

    public function turmasCreate() {

        if (!auth()->user()->isAdmin  && !auth()->user()->isTeacher) {
            return redirect('/alunos')->with("mssg", "Não tem Permissao para criar uma Turma ");
        }

        return view("createturma");
    }

    public function turmasStore(Request $request) {
        
        if (!auth()->user()->isAdmin && !auth()->user()->isTeacher) {
            return redirect('/turmas')->with("mssg", "Não tem Permissao para criar uma Turma ");
        }

        $ano = request('ano');
        $turma = request('turma');

        $turmaCreate = new Turma();
        $turmaCreate->ano = $ano;
        $turmaCreate->turma = $turma;

        $turmaCreate->save();

        return redirect('/turmas/create')->with("mssg", "Turma Criada");
    } 

    public function turmasEdit(Request $request) {
        $ano = request('ano');
        $turma = request('turma');
        $id = request('id');

        $turmaAdit = Turma::findOrFail($id);;
        $turmaAdit->ano = $ano;
        $turmaAdit->turma = $turma;

        $turmaAdit->save();

        return redirect(route('turma.show', $id))->with("mssg", "Turma Editado");
    }

    public function editTurma($id) {
        $user = auth()->user();
        $turma = Turma::findOrFail($id);

        return view("editturma", ['turma' =>$turma, 'currentUser' => $user]);
    }
    
    public function destroy($id) {
        try {
            $turma = Turma::findOrFail($id);
            $turma->delete();
        } catch (QueryException $ex) {
            return redirect(route('turma.show', $id))->with("error", "Erro Apagando a turma, Apague os Alunos ou mude de turma");
        }

        return redirect(route('turmas.show'));
    }
}
