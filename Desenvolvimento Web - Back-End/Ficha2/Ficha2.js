function pesoCorpural(weight, height) {
    var imc = weight / (height * height);
    if (imc < 18.5) {
        console.log("Abaixo do Peso")
    } else if (imc >= 18.5 && imc <= 25) {
        console.log("Peso normal")
    } else if (imc > 25 && imc <= 30) {
        console.log("Acima do peso")
    } else if (imc > 30) {
        console.log("Obeso")
    }
}
pesoCorpural(40, 1.8);

function reverseStr(str) {
    var splitted = str.split(" ");
    var inverted = "";
    splitted.forEach(item => {
        for (let i = item.length - 1; i >= 0; i--) {
            inverted += item[i];
        }
        inverted += " ";
    });
    console.log(inverted)
}

reverseStr("Hoje é Domingo")

function contarVogais(str) {
    var count = 0;
    var vogais = ["a", "e", "i", "o", "u"]
    for (let i = 0; i < str.length; i++) {
        for (let j = 0; j < vogais.length; j++) {
            if (str[i] == vogais[j]) {
                count++;
            }
        }
    }
    console.log(count)
}

contarVogais("Hello")


function contarLetras(str) {
    var vogais = {};
    for (let i = 0; i < str.length; i++) {
        if (str[i] != " ") {
            var letra = str[i].toLowerCase();
            if (vogais[str[i]] == null) {
                vogais[letra] = 1;
            } else {
                vogais[letra] = vogais[letra] + 1;
            }
        }
    }
    console.log(vogais)
}

contarLetras("Ola todo Bem")

function calculateWorkTime(entry, exit) {

    var entryT = entry.getTime();
    var exitT = exit.getTime();

    var mileseconds = (exitT - entryT) / 1000;
    var sec = (mileseconds) % 60;
    var min = (mileseconds / 60) % 60;
    var hours = (mileseconds / 3600) % 24

    console.log("H: " + hours + " M: " + min + " S: " + sec)
}

var entry = new Date("October 13, 2019 08:00:00");
var exitT = new Date("October 13, 2019 09:20:00")

calculateWorkTime(entry, exitT)

function drawRectangle(widht, height) {
    var ast = "*";
    var line = "";
    for (let i = 0; i < height; i++) {

        for (let j = widht; j > 0; j--) {
            line += ast;
        }

        console.log(line);
        line = "";
    }
}

drawRectangle(20, 5)

function drawTriagle(height) {
    var ast = "*";
    var line = "";
    for (let i = 0; i <= height; i++) {
        console.log(line);
        line += ast;
    }
}

drawTriagle(10);


function drawBox(lado) {
    var ast = "*";
    var space = " ";
    var line = "";
    for (let i = 0; i < lado; i++) {
        line += ast;
    }
    console.log(line);
    for (let i = 0; i < lado; i++) {
        line = "";
        line += ast;
        for (let b = 0; b < lado - 2; b++) {
            line += space;
        }
        line += ast;
        console.log(line)
    }
    line = "";
    for (let i = 0; i < lado; i++) {
        line += ast;
    }
    console.log(line);
}

drawBox(30)

var std1 = { name: "Teste1", number: 1, grade: 2 };
var std2 = { name: "Teste2", number: 2, grade: 16 };
var std3 = { name: "Teste3", number: 3, grade: 14 };
var std4 = { name: "Teste4", number: 4, grade: 4 };
var std5 = { name: "Teste5", number: 5, grade: 19 };

var students = [];
students.push(std1, std2, std3, std4, std5);

function listGrades(array) {
    console.log("Listagem de notas:")
    array.forEach(item => {
        console.log(item.grade)
    });
}

listGrades(students)

function bestGrade(array) {
    var grade = array[0].grade;
    array.forEach(element => {
        if (element.grade > grade) {
            grade = element.grade;
        }
    });
    console.log("Melhor nota: " + grade)
}

bestGrade(students)

function Media(array) {
    var total = 0;
    var media = 0;
    var counts = [];
    array.forEach(element => {
        total += element.grade
    });
    var media = (total) / array.length;
    console.log("Media: " + media)
    array.forEach(element => {
        counts.push(element.grade)
    });

    var closest = counts.reduce(function (prev, curr) {
        return (Math.abs(curr - media) < Math.abs(prev - media) ? curr : prev);
    });

    console.log(closest);
}

Media(students)

function worstGrade(array) {
    var grade = array[0].grade;
    array.forEach(element => {
        if (element.grade < grade) {
            grade = element.grade;
        }
    });
    console.log("Pior nota: " + grade)
}

worstGrade(students)

function NegativeGrades(array) {
    console.log("Negativas")
    array.forEach(item => {
        if (item.grade < 10) {
            console.log(item.grade)
        }
    });
}

NegativeGrades(students);


function PositiveGrades(array) {
    console.log("Positivas")
    array.forEach(item => {
        if (item.grade > 10) {
            console.log(item.grade)
        }
    });
}

PositiveGrades(students)