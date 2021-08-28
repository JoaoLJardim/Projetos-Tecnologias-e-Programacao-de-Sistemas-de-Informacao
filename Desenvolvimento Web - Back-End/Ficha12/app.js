var fs = require('fs');
var zlib = require('zlib');

function readFileFS(path) {
    fs.readFile(path,function (err,data) {
        console.log(data.toString());
    });
};

function readFileStream(path) {
    var readerStream = fs.createReadStream(path);
    var writeStream = fs.createWriteStream('copy.txt');
    readerStream.setEncoding('UTF8');

    //on Arrivel of new data
    readerStream.on('data',function (chunk) {
        writeStream.write(chunk,'UTF8');
    });

    //on Completion of the file
    readerStream.on('end',function () {
        console.log("File Completed ");
        writeStream.end();
    });

    //on error while reading the file
    readerStream.on('error',function (err) {
        console.log(err.stack);
    })

};

//readFileFS('text.txt');
//readFileStream('text.txt');


//Pipe
//var readerStream = fs.createReadStream('text.txt');
//var writeStream = fs.createWriteStream('copy.txt.gz');
//readerStream.pipe(writeStream);

//readerStream.pipe(zlib.createGzip()).pipe(writeStream);

fs.createReadStream("./copy.txt.gz").pipe(zlib.createGunzip()).pipe(fs.createWriteStream('unzip.exe'));