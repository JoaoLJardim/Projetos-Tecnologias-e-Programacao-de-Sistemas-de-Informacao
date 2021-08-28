//variaveis entrada da função media

function media(a,b) {
    var c = (a + b) / 2;
    if (c < 10) {
        return "Reprovado com Media "+c;
    }
    if (c >= 10) {
        return "Aprovado com Media "+c;
    }
};


console.log(media(10,17));

//variaveis entrada da função meses

function extenso(mes) {
    switch (mes) {
        case 1:
            console.log("Janeiro");
            break;
        case 2:
            console.log("Fevereiro");
            break;
        case 3:
            console.log("Março");
            break;
        case 4:
            console.log("Abril");
            break;
        case 5:
            console.log("Maio");
            break;
        case 6:
            console.log("Junho");
            break;
        case 7:
            console.log("Julho");
            break;
        case 8:
            console.log("Agosto");
            break;
        case 9:
            console.log("Setenbro");
            break;
         case 10:
            console.log("Outubro");
            break;
        case 11:
            console.log("Novembro");
            break;
        case 12:
            console.log("Dezenbro");
            break;
        default:
            console.log("N/A");
            break;
    }
}

extenso(12);

//calculadora
function calculadora(num1,num2,operacao) {
    if (operacao=="+"){
        console.log("Soma: " ,(num1 + num2));
    }else if (operacao =="-"){
        console.log("Subtração: " ,(num1 - num2));
    }else if (operacao =="*"){
        console.log("Multiplicação: ",(num1 * num2));
    }else if (operacao =="/"){
        console.log("Divisão: " ,(num1 / num2));
    }else if (operacao =="**"){
        console.log("Elevado: " ,(num1 ** num2));
    }
}

calculadora(2,2,"**");

// multiplos

function multiplo(value, value1) {
    for (let i = 1; i <= value; i++) {
        if (i % value1 == 0){
            console.log(i, " Multiplo de "+value1);
        }
    }
}

multiplo(20,5);

// soma 100

function sumof(value) {
    let soma = 0;
    for (let i = 1; i <= value; i++) {
        soma=soma+i;
    }
    console.log(soma);
}

sumof(100);

// factorial

function factorial(value) {
    let fac = 1;
    for (let i = value; i >= 1; i--) {
        fac = fac * i;
    }
    return fac;
}
var f = factorial(3);
console.log(f); 

// máximo, o mínimo e a média

var array = [1,2,6,1,1]

function calculateAverage(array) {
    let sum = 0 ;
    let average = 0;
    for (let i = 0; i < array.length; i++) {
        sum = sum + array[i]
    }
    average = sum / array.length;
    console.log(average)
}
calculateAverage(array)

function calculateMaximum(array) {
    let max = array[0];
    for (let i = 0; i < array.length; i++) {
        if (array[i] > max){
            max=array[i]
        }
    }
    console.log(max)
}

calculateMaximum(array)

function calculateMinimum(array) {
    let min = array[0];
    for (let i = 0; i < array.length; i++) {
        if (array[i] < min){
            min = array[i];
        }
    }
    console.log(min)
}

calculateMinimum(array)