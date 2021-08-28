const express = require('express');
const Sequelize = require('sequelize');

const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: false }));


var server = app.listen(8081, function () {
    var host = server.address().address;
    var port = server.address.port;

    console.log('Example app listening at http://%s:%s', host, port);
});

const sequelize = new Sequelize('ficha8', 'root', '',
    {
        dialect: 'mysql'
    })

sequelize.authenticate()
    .then(() => {
        console.log("Connection has been established")
    })
    .catch(err => {
        console.log('Unable to connect: ', err)
    })

const Person = sequelize.define('person', {
    firstname: Sequelize.TEXT,
    lastname: Sequelize.TEXT,
    profession: Sequelize.STRING,
    age: Sequelize.INTEGER
})

sequelize.sync({ force: false })
    .then(() => {
        console.log("Tables Created!");
        Person.bulkCreate([
            { firstname: "David", lastname: "Jardim", profession: "II", age: 99 },
            { firstname: "João", lastname: "Jardim", profession: "Estudante", age: 19 },
            { firstname: "Pedro", lastname: "Barreto", profession: "Chefe", age: 18 },
            { firstname: "Dinarte", lastname: "Vasconseles", profession: "Medico", age: 99 },
            { firstname: "Maria", lastname: "Sandrina", profession: "Porto", age: 99 },
        ])
            .then(() => {
                return Person.findAll();
            })
            .then((persons) => {
                //console.log(persons)
            })
    });


app.get('/', function (request, response) {
    response.send('ENDPOINT ROOT');
});

app.get('/persons', function (request, response) {
    Person.findAll()
        .then(persons => {
            response.send(persons)
        });
});

app.put('/persons', function (request, response) {
    Person.create(request.body).then(newPerson => {
        response.send("Novo id " + newPerson.id)
    })
});

app.delete('/persons', function (request, response) {
    Person.destroy({
        where: {
            id: request.body.id
        }
    }).then(removed => {
        if(removed == 0 ){
            response.send("Cannot find id")
        }else{
            response.send("Number of deleted instances: " + removed)
        }
    })
})

app.delete('/persons/:id', function (request, response) {
    Person.destroy({
        where: {
            id: request.params.id
        }
    }).then(removed => {
        if(removed == 0 ){
            response.send("Cannot find id")
        }else{
            response.send("Number of deleted instances: " + removed)
        }
    })
})

app.get('/persons/:id', function (request, response) {
    Person.findAll({
        where:{
            id: request.params.id
        }
    }).then(persons => {
        if(persons == 0 ){
            response.send("Cannot find id")
        }else{
            response.send(persons)
        }
        });
});

app.get('/persons/:age/:profession', function (request, response) {
    Person.findAll({
        where:{
            age: request.params.age,
            profession: request.params.profession
        }
    }).then(persons => {
        if(persons == 0 ){
            response.send("Cannot find id with profession")
        }else{
            response.send(persons)
        }
        });
});

app.post('/persons/:id', function (request, response) {
    Person.update(request.body,{
        where:{
            id: request.params.id
        }
    }).then(persons => {
        if(persons == 0 ){
            response.send("Cannot find id")
        }else{
            Person.findAll({
                where:{
                    id : request.params.id
                }
            }).then(person =>{
                response.send(person)
            })
        }
        });
});