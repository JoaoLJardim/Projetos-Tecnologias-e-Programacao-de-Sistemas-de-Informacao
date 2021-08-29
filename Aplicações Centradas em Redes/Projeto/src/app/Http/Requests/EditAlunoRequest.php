<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class EditAlunoRequest extends FormRequest
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
            'nome'=> 'required',
            'email'=> 'required|email',
            'img' => 'image|mimes:jpeg,png,jpg,gif|max:2048',
        ];
    }

    public function messages() {
        return [
            'img.mimes' => 'A imagem deve ser do tipo jpeg, png, jpg ou gif.',
            'img.max' => 'A imagem nao pode exceder os 2MB de espaço',
            'email.required'=>'The User Email must be a valid email address',
            'email.email'=>'The User Email must be a valid email address'
        ];
    }
}
