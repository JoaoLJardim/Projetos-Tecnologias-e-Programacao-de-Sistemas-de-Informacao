<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Aluno;
use App\Models\Turma;
use App\Models\User;
use App\Models\Nota;
use App\Http\Requests\AddAlunoRequest;
use App\Http\Requests\EditAlunoRequest;
use Illuminate\Support\Facades\Hash;

class AlunosController extends Controller
{
    public function showAlunos() {
        $alunos = Aluno::all();
        return view("alunos", ['alunos' => $alunos]);
    }

    public function showAluno($id) {
        $aluno = Aluno::findOrFail($id);
        $notas = Nota::where('aluno_id', $aluno->id)->get();

        return view("aluno", ['aluno' => $aluno , 'notas' => $notas]);
    }

    public function alunosCreate() {
        $turmas = Turma::all();

        if (!auth()->user()->isAdmin  && !auth()->user()->isTeacher) {
            return redirect('/alunos')->with("mssg", "Não tem Permissao para criar um Aluno ");
        }

        return view("createaluno", ['turmas' =>$turmas]);
    }

    public function alunosStore(AddAlunoRequest $request) {
        $nome = request('nome');
        $numero = request('num');
        $turma = request('turma');
        $email = request('email');
        $password = request('password');

        if (!auth()->user()->isAdmin  && !auth()->user()->isTeacher) {
            return redirect('/alunos/create')->with("mssg", "Não tem Permissao para criar um Aluno ");
        }

        $passwordEncryped =  Hash::make($password);

        $url = "";
        if ($request->has('img')) {
            $image = $request->file('img');

            $iname = 'aluno_'.time();
            $folder = 'img/alunos/';
            $fileName = $iname.'.'.$image->getClientOriginalExtension();
            $filePath = $folder . $fileName;

            $image->storeAs($folder,$fileName,'public');
            $url = "/storage/".$filePath;
        }

        $aluno = new Aluno();
        $aluno->nome = $nome;
        $aluno->num = $numero;
        $aluno->img = $url;
        $aluno->email = $email;
        $aluno->turma_id = $turma;
        $aluno->created_by = auth()->user()->id;
        $aluno->save();

        $user = new User();
        $user->aluno_id = $aluno->id;
        $user->name = $nome;
        $user->email = $email;
        $user->isAluno = true;
        $user->password = $passwordEncryped;
        $user->save();


        return redirect('/alunos/create')->with("mssg", "Aluno Criado");
    }

    public function alunosEdit(EditAlunoRequest $request) {
        $nome = request('nome');
        $numero = request('num');
        $turma = request('turma');
        $email = request('email');
        $password = request('password');
        $id = request('id');

        if (!auth()->user()->isAdmin  && !auth()->user()->isTeacher) {
            return redirect(route('aluno.show', $id))->with("mssg", "Não tem Permissao para Editar um Aluno ");
        }

        $passwordEncryped = Hash::make($password);

        $aluno = Aluno::findOrFail($id);
        $user = User::where('email', $aluno->email)->first();

        if ($aluno->created_by == auth()->user()->id || auth()->user()->isAdmin) {
        $url = "";
        if ($request->has('img')) {
            $image = $request->file('img');

            $iname = 'aluno_'.time();
            $folder = 'img/alunos/';
            $fileName = $iname.'.'.$image->getClientOriginalExtension();
            $filePath = $folder . $fileName;

            $image->storeAs($folder,$fileName,'public');
            $url = "/storage/".$filePath;

            $aluno->img = $url;
        }

        $user->name = $nome;
        $user->email = $email;
        $user->save();

        $aluno->nome = $nome;
        $aluno->num = $numero;
        $aluno->email = $email;
        $aluno->turma_id = $turma;
        $aluno->save();
        return redirect(route('aluno.show', $id))->with("mssg", "Aluno Editado");
    } else if (auth()->user()->email == $aluno->email){

        $url = "";
        if ($request->has('img')) {
            $image = $request->file('img');

            $iname = 'aluno_'.time();
            $folder = 'img/alunos/';
            $fileName = $iname.'.'.$image->getClientOriginalExtension();
            $filePath = $folder . $fileName;

            $image->storeAs($folder,$fileName,'public');
            $url = "/storage/".$filePath;

            $aluno->img = $url;
        }

        $user->name = $nome;
        $user->email = $email;
        $user->save();

        $aluno->nome = $nome;
        $aluno->email = $email;
        $aluno->save();
        return redirect(route('aluno.show', $id))->with("mssg", "Aluno Editado");
    }
    }

    public function destroy($id) {
        $aluno = Aluno::findOrFail($id);
        $notas = Nota::where('aluno_id', $aluno->id)->get();

        if ($aluno->created_by == auth()->user()->id || auth()->user()->isAdmin) {

        $alunoUser = User::where('email', $aluno->email)->first();
        
        foreach ($notas as $nota) {
            $nota->delete();
        }
        $aluno->delete();
        $alunoUser->delete();

        return redirect(route('alunos.show'));
        }
        return redirect(route('alunos.show'));
    }

    public function editAluno($id) {
        $user = auth()->user();
        $turmas = Turma::all();
        $aluno = Aluno::findOrFail($id);

        if ($aluno->created_by == auth()->user()->id || auth()->user()->isAdmin || auth()->user()->email == $aluno->email ) {
        return view("editaluno", ['aluno' => $aluno, 'turmas' =>$turmas, 'currentUser' => $user]);
        } else {
            return redirect(route('alunos.show'));
        }
    }

    public function addNota($id) {
        if (auth()->user()->isAdmin || auth()->user()->isTeacher ) {
            return view("addnota", ['id' =>$id]);
        } else {
            return redirect(route('alunos.show'));
        }
    }

    public function alunosNotaStore($id) {
        $disciplina = request('disciplina');
        $professor = request('professor');
        $nota = request('nota');
        
        $notaCreate = new Nota();
        $notaCreate->disciplina = $disciplina;
        $notaCreate->professor = $professor;
        $notaCreate->nota = $nota;
        $notaCreate->aluno_id = $id;
        $notaCreate->save();

        return redirect(route('aluno.show', $id));
    }
}
