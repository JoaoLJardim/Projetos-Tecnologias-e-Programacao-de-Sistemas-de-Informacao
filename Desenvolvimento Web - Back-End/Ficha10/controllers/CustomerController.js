const fs = require('fs');
const Customer = require('../sequelize').Customer;
const Order = require('../sequelize').Order;
var dateFormat = require('dateformat');

exports.getall = function (req,res) {
    log(req,res);
    Customer.findAll()
    .then(result =>{
        if (result == null){
            res.send('No user found');
        }else{
            res.send(result)
        }
    }).catch(err =>{
        res.send('Um Erro Aconteceu ao listar os dados' + err);
    })
}

exports.getuser = function (req,res) {
    log(req,res);
    Customer.findOne({
        where: {
            customerNumber: req.params.id
        }
    })
    .then(result =>{
        if (result == null){
            res.send('No user found');
        }else{
            res.send(result)
        }
    }).catch(err =>{
        res.send('Um Erro Aconteceu ao listar os dados' + err);
    })
}

exports.add = function (req,res) {
    log(req,res);
    Customer.create(req.body).then(newCustomer => {
        res.send("Novo id " + newCustomer.customerNumber)
    })
}

exports.deleteUser = function (req,res) {
    log(req,res);
    Customer.destroy({
        where: {
            customerNumber: req.params.id
        }
    }).then(removido =>{
        if (removido !=0){
            res.send('Customer Eliminado com sucesso '+removido);
        }else{
            res.send('Customer Não Encontrado'); 
        }
    })
}

exports.getorder = function (req,res) {
    log(req,res);
    Order.findOne({
        where: {
            customerNumber: req.params.cid,
            orderNumber: req.params.oid
        }
    })
    .then(result =>{
        if (result == null){
            res.send('No Order found');
        }else{
            res.send(result)
        }
    }).catch(err =>{
        res.send('Um Erro Aconteceu ao listar os dados' + err);
    })
}

function log(request,response) {
    var day=dateFormat(new Date(), "dd-mm-yyyy h:MM");
    var info = "customers"+request.path + ", " + request.method + ", " + day + "\n";
    fs.appendFileSync('./log.txt',info)
}