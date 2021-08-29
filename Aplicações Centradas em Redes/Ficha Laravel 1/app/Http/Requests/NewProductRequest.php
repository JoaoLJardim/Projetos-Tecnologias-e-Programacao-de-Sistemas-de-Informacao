<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class NewProductRequest extends FormRequest
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
            'url' => 'required|image|mimes:jpeg,png,jpg,gif|max:2048'
        ];
    }

    public function messages() {
        return[
            'name.required' => 'O nome do Produto é Obrigatório',
            'url.required' => 'A image é Obrigatoria',
            'url.image' => 'A image deve ser uma imagem.',
            'url.mimes' => 'A image pode ser jpeg,png,jpg,gif',
            'url.max' => 'A imagem Não pode exceder 2MB',
        ];
    }
}
