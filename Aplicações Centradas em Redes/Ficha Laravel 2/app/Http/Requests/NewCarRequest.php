<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class NewCarRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     *
     * @return bool
     */
    public function authorize()
    {
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array
     */
    public function rules()
    {
        return [
            'name' => 'required',
            'img' => 'required|image|mimes:jpeg,png,jpg,gif|max:2048'
        ];
    }

    public function messages() {
        return [
            'name.required' => 'O nome do carro e Obrigatório.',
            'img.required' => 'A Imagem e Obrigatória.',
            'img.image' => 'A Imagem deve ser uma imagem.',
            'img.mimes' => 'A imagem pode ser jpeg,png,jpg,gif',
            'img.max' => 'A imagem Não pode exceder 2MB',
        ];
    }
}
