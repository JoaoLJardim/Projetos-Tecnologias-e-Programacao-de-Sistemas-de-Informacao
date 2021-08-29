<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Cars;
use App\Http\Requests\NewCarRequest;
use App\Models\marcas;

class CarrosController extends Controller
{
    public function index() {
        $marcas = marcas::all();
        $cars = Cars::all();

        return view('carros',  ['carros' => $cars, 'marcas'=>$marcas]);
    }

    public function show($id) {
        $car = Cars::findOrFail($id);
    
        return view('detalhes', ['produto' => $car]);
    }

    public function create() {
        $marcas = marcas::all();

        return view('createCarros', ['marcas'=> $marcas]);
    }

    public function store(NewCarRequest $request) {
        $name = request('name');
        $desc = request('desc');
        $marca = request('marca');

        $url = "";
        if ($request->has('img')) {
            $image = $request->file('img');

            $iname = 'car'.'_'.time();
            $folder = 'img/carros/';
            $fileName = $iname. '.'.$image->getClientOriginalExtension();
            $filePath = $folder .$fileName;

            $image->storeAs($folder,$fileName,'public');
            $url = "/storage/".$filePath;
        }

    
        $carro = new Cars();
        $carro->nome = $name;
        $carro->desc= $desc;
        $carro->img = $url;
        $carro->marca_id = $marca;

        $carro->save();

        return redirect('/carros/create')->with('mssg', "Carro Criado");
    }

    public function destroy($id) {
        $carro = Cars::findOrFail($id);
        $carro->delete();

        return redirect('/carros');
    }

    public function carsPorMarca($id) {
        $marcas = marcas::all();
        $marca = marcas::findOrFail($id);
        $cars = $marca->marcas;

        return view('carros', ['carros' => $cars, 'marcas'=> $marcas,'actMarca'=>$marca]);
    }
}
