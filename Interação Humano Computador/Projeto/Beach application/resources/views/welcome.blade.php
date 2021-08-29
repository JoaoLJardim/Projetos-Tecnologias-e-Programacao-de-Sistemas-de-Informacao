@extends('layouts.app')
@section('content')
    <div class="homeImg">
        <img src="img/Home.png" alt="" width=100%>
    </div>


    <style>div.Informações{text-align: center;}</style>
    <div class="Informações" id="Info">  
       <body> <br><br><h1>INFORMAÇÕES</h1><br></body>
    </div>


    <div>
        <div class="card-deck">
        <div class="card" style="width: 18rem;">
          <img src="img/estacionamento.png" class="card-img-top" alt="">
          <div class="card-body">
            <h5 class="card-title">Estacionamento</h5><br>
            <p class="card-text">Informações correspondentes ao estacionamento municipal</p>
            <div class="w3-container">
            <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-black">Ler mais</button>
          <div id="id01" class="w3-modal">
            <div class="w3-modal-content">
              <div class="w3-container">
                <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright">&times;</span>
                <h5 class="modal-title">Estacionamento</h5>
                <p>Horário de funcionamento </p>
        
                    <p>- Dias úteis das 8h até às 22h </p>
        
                    <br><p>Taxas </p>
        
                    <p>- 1h / fração: 0.50€ </p>
        
                    <p>- Cartão de reserva mensal para funcionários da Câmara Municipal da Calheta / Dias úteis: 15€ com IVA </p>
        
                    <p>- Cartão de reserva mensal / Dias úteis: 35€ com IVA </p>
        
                    <p>- Cartão de reserva mensal: 55€ com Iva </p>
              
              </div>
            </div>
          </div>
        </div>
           
        
          </div>
        </div>
        <div class="card" style="width: 18rem;">
          <img src="img/bandeira.png" class="card-img-top" alt="">
          <div class="card-body">
            <h5 class="card-title">Condiçoes maritimas</h5>
            <p class="card-text">Mantanha-se sempre informado das condições marítimas da nossa praia</p>
            <div class="w3-container">
            <button onclick="document.getElementById('id02').style.display='block'" class="w3-button w3-black">Ler mais</button>
          <div id="id02" class="w3-modal">
            <div class="w3-modal-content">
              <div class="w3-container">
                <span onclick="document.getElementById('id02').style.display='none'" class="w3-button w3-display-topright">&times;</span>
                <h5 class="modal-title">Condições Marítimas</h5><br>
                <p>Bandeira Atual</p>

                <p>- Bandeira Vermelha</p><br>

                <p>Outras Bandeiras</p>
        
                <p>- Bandeira Verde </p>
        
                <p>- Bandeira Amarela </p>
        
               <p>- Bandeira Azul </p>
        
               <p>- Bandeira metade amarela metade vermelha </p>
        
               <p>- Bandeira Xadrez Azul e Branco </p>
        
              <p>- Bandeira Negra </p>
        
               <p>- Bandeira Roxa </p>
              
              </div>
            </div>
          </div>
        </div>
          </div>
        </div>
        <div class="card" style="width: 18rem;">
          <img src="img/restauracao.jpg" class="card-img-top" alt="">
          <div class="card-body">
            <h5 class="card-title">Restauração</h5>
            <p class="card-text">Fique a conhecer os bares e restaurantes perto da nossa praia</p>
            <div class="w3-container">
            <button onclick="document.getElementById('id03').style.display='block'" class="w3-button w3-black">Ler mais</button>
          <div id="id03" class="w3-modal">
            <div class="w3-modal-content">
              <div class="w3-container">
                <span onclick="document.getElementById('id03').style.display='none'" class="w3-button w3-display-topright">&times;</span>
                <h5 class="modal-title">Restauração</h5><br>
                <p>Bar da Praia Beach Club </p>
        
                <p>- Gastronomia: Bar, Pizza, Marisco, Europeia, Portuguesa </p>
        
                <p>- Refeições: Pequeno-almoço, Almoço, Jantar, Bebidas </p>
        
                <p>- Horário Funcionamento: todos os dias das 10h até às 21h </p>
        
                <p>- Morada: Avenida D. Manuel I n8, Calheta, Madeira 9370-133 Portugal </p>
        
                <p>- Telefone: +351 924 434 118 </p><br>
        
                
        
                <p>LookAll Beach Bar and Restaurant </p>
        
                <p>- Gastronomia: Bar, Europeia, Portuguesa, Internacional </p>
        
                <p>- Refeições: Almoço, Jantar, Bebidas </p>
        
                <p>- Horário Funcionamento:  todos os dias das 9h às 22h </p>
        
               <p>- Morada: Avenida D. Manuel I n3, Lombo do Doutor, Calheta, Madeira 9370-133 Portugal </p>
        
               <p>- Telefone: +351 291 820 300 </p>
              
              </div>
            </div>
          </div>
        </div>
          </div>
        </div>
        <div class="card" style="width: 18rem;">
          <img src="img/material.jpg" class="card-img-top" alt="">
          <div class="card-body">
            <h5 class="card-title">Material de aluguer</h5>
            <p class="card-text">Fique informado sobre o preçário e o material que temos para melhorar o seu aproveitamento da nossa praia</p>
            <div class="w3-container">
            <button onclick="document.getElementById('id04').style.display='block'" class="w3-button w3-black">Ler mais</button>
          <div id="id04" class="w3-modal">
            <div class="w3-modal-content">
              <div class="w3-container">
                <span onclick="document.getElementById('id04').style.display='none'" class="w3-button w3-display-topright">&times;</span>
                <h5 class="modal-title">   Material para aluger </h5><br>
              
               <p> Espreguiçadeira: 2€ </p>
        
               <p> Guarda-Sol: 1.50€ </p>
        
               <p> Duche: 1€ </p>
        
               <p> Cinzeiro: 1€ </p>
                    
              </div>
            </div>
          </div>
        </div>
          </div>
        </div>
        </div>
    </div><br>

    <div class="mapaImg">
        <img src="img/mapa_acessibilidades.png" alt="" width=100%>
    </div>

    <div class="footer">
        <body style="background-color:rgb(57, 53, 59); color:rgb(193,193,193)">
            <br><h3>Contactos</h3><br>
            <h5>Câmara Municipal da Calheta</h5>
            <h5>Avenida D. Manuel I, n46 - Edifício Paços do Concelho</h5>
            <h5>9370-135 Vila da Calheta</h5>
            <h5>291 820 200</h5>
            <h5>963 434 157</h5>
            <h5>camara@cmcalheta.pt</h5>
        </body>
    </div>
@endsection