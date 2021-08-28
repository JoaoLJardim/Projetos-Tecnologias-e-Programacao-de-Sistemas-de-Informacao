//require do módulo Emitter
var Emitter = require("./Emitter.js");
var Config = require("./Config.js");

//Objeto
var person = {
    name: "João",
    age: 19,
    gender: "M"
};

//instanciar a Classe Emitter
var emtr = new Emitter();

//register o listener para o event LOGIN
emtr.on(Config.LOGIN,function () {
    console.log("Welcome user");
})

emtr.on(Config.LOGIN,function () {
    console.log("Welcome user Ola");
})

emtr.on(Config.LOGOUT,function () {
    console.log("Goodbye user");
})
emtr.on(Config.LOGOUT,function () {
    console.log("Goodbye user Ola");
})
emtr.on(Config.LOGOUT,function () {
    console.log("Goodbye user João");
})

//Executar o listener para o event Login
emtr.emit(Config.LOGIN);

console.log("")

person.profession = "Coder"
console.log ("Nome:" + person.name);
var string_json = JSON.stringify(person);

console.log(string_json);

var str = JSON.parse('{"Nome":"João","Idade":19,"Genero":"M"}');

console.log("Nome:" + str.Nome);
console.log("Idade:" + str.Idade);
console.log("Genero:" + str.Genero);

str.Idade = 49;

console.log("Idade:" + str.Idade);