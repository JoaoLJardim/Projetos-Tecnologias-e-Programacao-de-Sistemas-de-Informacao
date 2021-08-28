var express = require('express');
var router = express.Router();
const fs = require('fs');
var dateFormat = require('dateformat');

/* GET home page. */
router.get('/', function(req, res, next) {
    log(req,res);
    res.download("./log.txt",function (err) {
        if (err){
            res.end("O ficheiro que tento aceder nao existe");
            res.end(err.message);
        }else{

        }
    })
});

function log(request,response) {
    var day=dateFormat(new Date(), "dd-mm-yyyy h:MM");
    var info = "log"+request.path + ", " + request.method + ", " + day + "\n";
    fs.appendFileSync('./log.txt',info);
};

module.exports = router;
