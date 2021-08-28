const express = require('express');
const mysql = require('mysql');
const bodyParser = require('body-parser');

const app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:false}));


var server = app.listen(8081,function () {
    var host = server.address().address;
    var port = server.address.port;

    console.log('Example app listening at http://%s:%s', host, port);
});

var connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'person' 
});



app.get('/',function (request,response) {
    response.send("ROOT");
});


app.get('/persons',function (request,response) {
    connection.query("select * from persons",function (err,results,fields) {
        response.send(results);
    });
});

app.put('/persons',function (request,response) {
    var person = request.body;
    connection.query("INSERT INTO persons set ?", person ,function (err, result) {
        if (err) throw err;
        response.send("1 person inserted");
      });
});

app.delete('/persons',function (request,response) {
    var person = request.body;
    connection.query("DELETE FROM persons WHERE id = ?", person.id ,function (err, results,fields) {
        if (err) throw err;
        response.send('foi removido com sucesso');
      });
});


app.get('/persons/:id',function (request,response) {
    var person = request.params.id;
    connection.query("SELECT * FROM persons WHERE id = ?",person,function (err, results,fields) {
        if (err) throw err;
        response.send(results);
      });
});


app.get('/persons/:age/:profession',function (request,response) {
    var age = request.params.age;
    var profession = request.params.profession;
    connection.query("SELECT * FROM persons WHERE age = ? AND profession = ?",[age,profession],function (err, results,fields) {
        if (err) throw err;
        response.send(results);
      });
});

app.post('/persons/:id',function (request,response) {
    var person = request.body;
    var id = request.params.id;
    connection.query("UPDATE persons SET ? WHERE id = ?" , [person, id] ,function (err, results,fields) {
        if (err) throw err;
        response.send('Foi Atualizado com sucesso');
      });
});
