const User = require('../sequelize').User;
var jwt = require('jsonwebtoken');

exports.getUsers = function (req,res) {
    User.findAll().then(result =>{
        res.send(result);
    })  
}

exports.setUsers = function(req,res) {
    User.create(req.body).then(newPerson => {
        res.send("Novo id " + newPerson.id)
    })
}

exports.deleteUser = function (req,res) {
    User.destroy({
        where: {
            id: req.param.id
        }
    }).then(removed => {
        if(removed == 0 ){
            response.send("Cannot find id")
        }else{
            response.send("Number of deleted instances: " + removed)
        }
    })
}

exports.ShowUser = function (req,res) {
    User.findAll({
        where: {
            id: req.param.id
        }
    }).then(persons => {
        if(persons == 0 ){
            res.send("Cannot find id with profession")
        }else{
            res.send(persons)
        }
        });
}

exports.UpdateUser = function (req,res) {
    User.update(request.body,{
        where:{
            id: request.params.id
        }
    }).then(users => {
        if(users == 0 ){
            response.send("Cannot find id")
        }else{
            User.findAll({
                where:{
                    id : request.params.id
                }
            }).then(user =>{
                response.send(user)
            })
        }
        });
}