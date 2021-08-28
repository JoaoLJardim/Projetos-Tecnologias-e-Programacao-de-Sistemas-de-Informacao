const express = require('express');
const fs = require('fs');
const bodyParser = require("body-parser");

const app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

function readFile(file) {
    var data = fs.readFileSync(file);
    return data;
};

function writeFile(path, data) {
    fs.writeFileSync(path, data)
}

//readFile('./persons.json');

var server = app.listen(8081, function () {
    var address = server.address().address;
    var port = server.address().port;

    console.log("Server running on address %s and port %s", address, port)
});

app.get('/', function (request, response) {
    response.send("Hello World")
});

app.get('/users', function (request, response) {
    var data = readFile('./persons.json');
    response.send(JSON.parse(data));
});

app.put('/users', function (request, response) {
    var data = JSON.parse(readFile('./persons.json'));
    var size = Object.keys(data).length;
    size++;
    var person = request.body;
    person.id = size;
    data["person" + size] = person;
    writeFile("./persons.json", JSON.stringify(data));
    response.send(person);
});


app.delete('/users/:id',function (request,response) {
    var data = JSON.parse(readFile('./persons.json'));
    var id = request.params.id;
    var p1 = data['person' + id];
    delete data['person' + id]
    writeFile("./persons.json", JSON.stringify(data));
    response.send(data);
});

app.get('/users/:id',function (request,response) {
    var data = JSON.parse(readFile('./persons.json'));
    var id = request.params.id;
    var person = data['person' + id];
    if(person == undefined){
        response.send("PERSON NOT FOUND")
    }else{
        response.send(person);
    }
    
});

app.post('/users/:id',function (request,response) {
    var data = JSON.parse(readFile('./persons.json'));
    var id = request.params.id;
    var person = data['person' + id];
    if(person == undefined){
        response.send("PERSON NOT FOUND")
    }else{
        data["person"+id]= request.body;
        data["person"+id].id = id;
        writeFile("./persons.json", JSON.stringify(data));
        response.send(data["person"+id]);
    }
});