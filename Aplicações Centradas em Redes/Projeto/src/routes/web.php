<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

// Alunos Routes GET
Route::get('/alunos', [App\Http\Controllers\AlunosController::class, 'showAlunos'])->name('alunos.show');

Route::get('/alunos/create', [App\Http\Controllers\AlunosController::class, 'alunosCreate'])->middleware('auth')->name('alunos.create');

Route::get('/alunos/{id}', [App\Http\Controllers\AlunosController::class, 'showAluno'])->name('aluno.show');

Route::get('/alunos/{id}/edit', [App\Http\Controllers\AlunosController::class, 'editAluno'])->middleware('auth')->name('aluno.edit');

Route::get('/alunos/{id}/nota', [App\Http\Controllers\AlunosController::class, 'addNota'])->middleware('auth')->name('aluno.add.nota');

Route::delete('/alunos/{id}', [App\Http\Controllers\AlunosController::class, 'destroy'])->name('alunos.destroy')->middleware('auth');

// Turmas Routes GET
Route::get('/turmas', [App\Http\Controllers\TurmasController::class, 'showTurmas'])->name('turmas.show');

Route::get('/turmas/create', [App\Http\Controllers\TurmasController::class, 'turmasCreate'])->middleware('auth')->name('turmas.create');

Route::get('/turmas/{id}', [App\Http\Controllers\TurmasController::class, 'showTurma'])->name('turma.show');

Route::get('/turmas/{id}/edit', [App\Http\Controllers\TurmasController::class, 'editTurma'])->middleware('auth')->name('turma.edit');

Route::delete('/turmas/{id}', [App\Http\Controllers\TurmasController::class, 'destroy'])->name('turmas.destroy')->middleware('auth');

// Alunos Routes POST
Route::post('/alunos', [App\Http\Controllers\AlunosController::class, 'alunosStore'])->middleware('auth')->name('alunos.store');
Route::post('/alunos/edit', [App\Http\Controllers\AlunosController::class, 'alunosEdit'])->middleware('auth')->name('alunos.edit');

// Turmas Routes POST
Route::post('/turmas', [App\Http\Controllers\TurmasController::class, 'turmasStore'])->middleware('auth')->name('turmas.store');
Route::post('/turmas/edit', [App\Http\Controllers\TurmasController::class, 'turmasEdit'])->middleware('auth')->name('trumas.edit');

// Nota Routes POST
Route::post('/nota/{id}', [App\Http\Controllers\AlunosController::class, 'alunosNotaStore'])->middleware('auth')->name('alunos.nota.store');

// 
Auth::routes();

Route::get('/home', [App\Http\Controllers\HomeController::class, 'index'])->name('home');

Route::get('/contactos', function () {
    return view('contactos');
})->name('contactos');