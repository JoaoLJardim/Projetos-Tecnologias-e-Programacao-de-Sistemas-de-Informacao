@extends('layouts.app')

@section('content')
<div style="margin: 50px">
    <h2>Profile</h2><br>

    Nome: {{auth()->user()->name}}<br><br>
    Email: {{auth()->user()->email}}
</div>

@endsection
