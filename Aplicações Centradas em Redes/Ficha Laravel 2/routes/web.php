<?php

use App\Http\Controllers\CarrosController;
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
})->name('home');

Route::get('/carros', [CarrosController::class, 'index'])->name('cars.index');

Route::get('/carros/marca/{id}', [CarrosController::class, 'carsPorMarca'])->name('cars.by.marca');

Route::get('/carros/create', [CarrosController::class, 'create'])->name('cars.create')->middleware('auth');

Route::post('/carros', [CarrosController::class, 'store'])->name('cars.store')->middleware('auth');

Route::get('/carros/{id}', [CarrosController::class, 'show'])->name('cars.show');

Route::delete('/carros/{id}', [CarrosController::class, 'destroy'])->name('cars.destroy')->middleware('auth');

Auth::routes();

Route::get('/home', [App\Http\Controllers\HomeController::class, 'index'])->name('home');
