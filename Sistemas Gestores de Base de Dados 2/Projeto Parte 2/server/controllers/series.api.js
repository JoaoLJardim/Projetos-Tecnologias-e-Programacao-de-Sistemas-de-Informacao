var express = require("express"),
    router = express.Router(),
    series = require("../models/series");

router.get("/", function(req, res) {
    series.find({}, function(err, data) {
        if (err) {
            res.send("error");
            return;
        }
        res.send(data);
    });
});

router.get("/:id", function(req, res) {
    var id = req.params.id;
    series.find({ _id: id }, function(err, data) {
        if (err) {
            res.send("error");
            return;
        }
        res.send(data[0]);
    });
});

router.post("/", function(req, res) {
    var obj = req.body;
    var model = new series(obj);
    model.save(function(err) {
        if (err) {
            res.send("error");
            return;
        }
        res.send("created");
    });
});

router.post("/:id", function(req, res) {
    var id = req.params.id;
    var obj = req.body;

    series.findByIdAndUpdate(id, { serie_id: obj.serie_id, nome: obj.nome, data: obj.data, rating: obj.rating, temporada_id: obj.temporada_id, diretores: obj.diretores },
        function(err) {
            if (err) {
                res.send("error");
                return;
            }
            res.send("updated");
        });
});

router.delete("/:id", function(req, res) {
    var id = req.params.id;
    series.findByIdAndRemove(id, function(err) {
        if (err) {
            res.send("error");
            return;
        }
        res.send("deleted");
    });
});


// Add Diretor
router.post("/:id/diretore", function(req, res) {
    var id = req.params.id;
    var obj = req.body;

    series.findOne({_id: id}, function(err, data) {
        var diretoreObject = {
            diretor_id: obj.diretor_id,
            nome: obj.nome,
            telefone: obj.telefone,
            morada: obj.morada
        };

        if (err) {
            res.send("error");
            return;
        }

        data.diretores.addToSet(diretoreObject);
        data.save(function (err) {
            if (err) {
                res.send("error");
                return;
            }

            res.send(data)
        })
    });
});

router.post("/:id/temporada", function(req, res) {
    var id = req.params.id;
    var obj = req.body;

    series.findOne({_id: id}, function(err, data) {
        if (err) {
            res.send("error");
            return;
        }

        data.temporada_id.addToSet(obj._id);
        data.save(function (err) {
            if (err) {
                res.send("error");
                return;
            }

            res.send(data)
        })
    });
});

router.delete("/:id/temporada/:temporada", function(req, res) {
    var id = req.params.id;
    var temporadaId = req.params.temporada;


    series.findOne({_id: id}, function(err, data) {
        if (err) {
            res.send("error");
            return;
        }

        data.temporada_id(temporadaId).remove();

        data.save(function (err) {
            if (err) {
                res.send("error");
                return;
            }

            res.send(data)
        })
    });
});

router.delete("/:id/diretore/:diretore", function(req, res) {
    var id = req.params.id;
    var diretoreId = req.params.diretore;


    series.findOne({_id: id}, function(err, data) {
        if (err) {
            res.send("error");
            return;
        }

        data.diretores.diretor_id(diretoreId).remove();

        data.save(function (err) {
            if (err) {
                res.send("error");
                return;
            }

            res.send(data)
        })
    });
});

module.exports = router;