<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class AddAlunoRequest extends FormRequest
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
            'num'=>'required',
            'email'=> 'required|email|unique:users,email',
            'password' => 'required|min:8',
            'img' => 'image|mimes:jpeg,png,jpg,gif|max:2048',
            'turma'=> 'required'
        ];
    }

    public function messages() {
        return [
            'nome.required' => 'E necessario um nome para o aluno',
            'num.required' => 'Um aluno necessita de um numero',
            'email.required'=>'The User Email must be a valid email address',
            'email.email'=>'The User Email must be a valid email address',
            'password.required' => 'E Necessario uma Palavra pass',
            'password.min' => 'A palavra pass tem que ter mais de 6 digitos',
            'img.mimes' => 'A imagem deve ser do tipo jpeg, png, jpg ou gif.',
            'img.max' => 'A imagem nao pode exceder os 2MB de espaço'
        ];
    }
}
