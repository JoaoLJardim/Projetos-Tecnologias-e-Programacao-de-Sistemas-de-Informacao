const express = require('express');
const fs = require('fs');

const app = express();

function log(request,response) {
    var info = request.path + ", " + request.method + ", " + new Date() + "\n";
    fs.appendFileSync('./log.txt',info)
}

var server = app.listen(8081, function () {
    var host = server.address().address;
    var port = server.address().port;
  
    //criar um ficheiro
    fs.open('log.txt', 'a',function (err, fd) {
        console.log("File was created "+fd);
    });

    console.log("Example app listening at http://%s:%s", host, port);  
});

app.get('/',function (request,response) {
    log(request,response);

    var page = '<!DOCTYPE html><html><head><title>Page Title From File</title></head><body><h1>This is a Heading</h1><p>{Message}</p></body></html>';
    var date = new Date();

    //var file = fs.readFileSync('./index.html',"utf-8");
    
    page = page.replace('{Message}',date.toDateString())
    
    response.writeHead(200,{
        "Content-Lenght" : Buffer.byteLength(page),
        "Content-Type": "text/html"
    });
    response.end(page);
});

app.get("/user/:name",function (request,response) {
    log(request,response);
   response.send("Welcome: " + request.params.name + "!"); 
});

app.get("/log",function (request,response) {
    log(request,response);
    var file = fs.readFileSync("./log.txt","utf-8");
    response.writeHead(200,{
        "Content-Lenght" : Buffer.byteLength(file),
        "Content-Type": "text/plain"
    });
    response.end(file)
});

app.get("/log.txt",function (request,response) {
    log(request,response);
    response.download("./log.txt",function (err) {
        if (err){
            response.end("O ficheiro que tento aceder nao existe");
            response.end(err.message);
        }else{

        }
    })
});

app.get("/clear", function (request,response) {
    fs.unlinkSync("./log.txt");
    response.send("File Deleted")
})