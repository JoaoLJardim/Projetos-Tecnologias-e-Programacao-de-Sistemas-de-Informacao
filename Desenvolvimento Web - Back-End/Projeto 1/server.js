const express = require('express');
const mysql = require('mysql');
const bodyParser = require('body-parser');
const fs = require('fs');

const app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

var server = app.listen(8081, function () {
    var host = server.address().address;
    var port = server.address.port;

    console.log('Example app listening at http://localhost:8081');
});

var connection = mysql.createConnection({
    host: '',
    user: '',
    password: '',
    database: ''
});

app.get('/', function (request, response) {
    var file = fs.readFileSync('./index.html',"utf-8");
    
    response.writeHead(200,{
        "Content-Lenght" : Buffer.byteLength(file),
        "Content-Type": "text/html"
    });
    response.end(file);
});

app.get('/videos', function (request, response) {
    connection.query("select * from videos", function (err, results, fields) {
        response.send(results);
    });
});

app.put('/videos', function (request, response) {
    var video = request.body;
    connection.query("INSERT INTO videos set `uploader` = '" + video.uploader + "', `title` = '" + video.title + "', `description` = '" + video.description + "', `duration` = " + video.duration + ", `url` = '" + video.url + "', `views` = " + video.views + ", `likes` = " + video.likes + ", `dislikes` = " + video.dislikes + ", `comments` = '" + JSON.stringify(video.comments) + "', `tags` ='" + JSON.stringify(video.tags) + "';", video, function (err, result) {
        if (err) throw err;
        response.send("1 video inserted id:" + result.insertId);
    });
});

app.get('/videos/byuploader/:uploader', function (request, response) {
    connection.query("select * from videos where uploader = '" + request.params.uploader + "' ", function (err, results, fields) {
        response.send(results);
    });
});

app.post('/videos/likes/:video_id/:likes', function (request, response) {
    var likes = request.params.likes;
    var video_id = request.params.video_id;
    connection.query("UPDATE videos SET `likes` = (videos.likes +" + likes + ") WHERE videos_id = " + video_id, function (err, results, fields) {
        if (results.affectedRows > 0) {
            connection.query("select * from videos where videos_id = '" + request.params.video_id + "' ", function (err, results, fields) {
                response.send(results);
            });
        } else {
            response.send('Id não encontrado')
        }
    });
});

app.get('/videos/byid/:id', function (request, response) {
    var id = request.params.id;
    connection.query("select * from videos where videos_id = ? ", id, function (err, results, fields) {
        response.send(results);
    });
});

app.get('/videos/bytags/', function (request, response) {
    var body = request.body;
    var tags = [];
    var size_body = Object.keys(body).length;
    for (let i = 1; i <= size_body; i++) {
        var str = body[i];
        tags.push(str.toLowerCase())
    }
    var array = [];
    connection.query("select * from videos", function (err, results, fields) {
        var size1 = Object.keys(results).length;
        for (let i = 0; i < size1; i++) {
            var string =results[i]["tags"];
            var json = JSON.parse(string);
            var size_json = Object.keys(json).length;

            for (let a = 1; a <= size_json; a++) {
                if (tags.includes(json[a].toLowerCase())){
                    array.push(results[i])
                }
            }
        }
        response.send(array)
    });
});

app.delete('/videos/:id', function (request, response) {
    var id = request.params.id;
    connection.query("DELETE FROM videos WHERE videos_id = ?", id, function (err, results, fields) {
        if (results.affectedRows > 0) {
            response.send('Video eliminado com sucesso')
        } else {
            response.send('Id não encontrado')
        }
    });
});

app.post('/videos/dislikes/:video_id/:dislikes', function (request, response) {
    var dislikes = request.params.dislikes;
    var video_id = request.params.video_id;
    connection.query("UPDATE videos SET `dislikes` = (videos.dislikes+" + dislikes + ") WHERE videos_id = " + video_id, function (err, results, fields) {
        if (results.affectedRows > 0) {
            connection.query("select * from videos where videos_id = '" + request.params.video_id + "' ", function (err, results, fields) {
                response.send(results);
            });
        } else {
            response.send('Id não encontrado')
        }
    });
});

app.post('/videos/comments/:id', function (request, response) {
    var array = [];
    var comment = request.body;
    var id = request.params.id;
    connection.query("select * from videos where videos_id = ? ", id, function (err, results, fields) {
        var lenght = 1;
        var string = results[0]["comments"];
        var json = JSON.parse(string);

        var size = Object.keys(json).length;
        var size1 = Object.keys(comment).length;

        for (let i = 1; i <= size; i++) {
            array.push('"' + [lenght] + '":"' + json[i] + '"')
            lenght++;
        }

        for (let i = 1; i <= size1; i++) {
            array.push('"' + [lenght] + '":"' + comment[i] + '"')
            lenght++;
        }

        var sql = "UPDATE videos SET `comments` = '{" + array + "}' WHERE videos_id = " + id;

        connection.query(sql, function (err, results, fields) {
            if (results.affectedRows > 0) {
                connection.query("select * from videos where videos_id = '" + id + "' ", function (err, results, fields) {
                    response.send(results);
                });
            } else {
                response.send('Id não encontrado')
            }
        });

    });
});

app.get('/videos/mostlikes', function (request, response) {
    connection.query("select * from `videos` ORDER BY videos.likes DESC", function (err, results, fields) {
        response.send(results);
    });
});