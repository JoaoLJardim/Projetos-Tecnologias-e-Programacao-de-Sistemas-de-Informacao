<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use App\Models\Cars;

class marcas extends Model
{
    use HasFactory;

    protected $table = 'marcas';

    public function marcas() {
        return $this->hasMany('App\Models\Cars','marca_id','id');
    }
}
