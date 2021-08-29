<?php
use App\Http\Controllers\UsersController;
use Illuminate\Support\Facades\Route;

use Illuminate\Support\Facades\Auth;
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
})->name('index');

// Profile Routes 

Route::get('/profile', function () {
    return view('profile');
})->name('profile')->middleware('auth');


// Utilizadores Routes
Route::get('/utilizadores',[UsersController::class,'index'])->name('utilizador.index')->middleware('auth');

Route::get('/utilizadores/edit/{id}',[UsersController::class,'edit'])->name('utilizador.edit')->middleware('auth');

Route::post('/utilizadores/{id}',[UsersController::class,'update'])->name('utilizador.update')->middleware('auth');

Route::delete('/utilizadores/{id}',[UsersController::class,'destroy'])->name('utilizador.destroy')->middleware('auth');


// Tickets Routes
Route::get('/tickets', [App\Http\Controllers\TicketsController::class, 'showTickets'])->middleware('auth')->name('tickets.showAll');

Route::get('/tickets/create', [App\Http\Controllers\TicketsController::class, 'createTicket'])->middleware('auth')->name('tickets.create');

Route::get('/tickets/edit/{id}', [App\Http\Controllers\TicketsController::class, 'editTicket'])->middleware('auth')->name('tickets.edit');

Route::get('/tickets/{id}', [App\Http\Controllers\TicketsController::class, 'showTicket'])->middleware('auth')->name('tickets.show');

Route::post('/tickets/edit', [App\Http\Controllers\TicketsController::class, 'ticketStoreEdit'])->middleware('auth')->name('tickets.store.edit');

Route::post('/tickets/store', [App\Http\Controllers\TicketsController::class, 'ticketStore'])->middleware('auth')->name('tickets.store');

// PayPal Routes
Route::get('/paypal/pay/{id}', [App\Http\Controllers\PaymentController::class, 'payWithPayPal'])->middleware('auth')->name('paypal.pay');

Route::get('/paypal/status/{id}', [App\Http\Controllers\PaymentController::class, 'payPalStatus'])->middleware('auth')->name('paypal.status');


Auth::routes();

Route::get('/home', [App\Http\Controllers\HomeController::class, 'index'])->name('home');
