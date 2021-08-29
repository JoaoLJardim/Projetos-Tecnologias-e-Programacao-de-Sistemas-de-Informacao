var express = require("express"),
    router = express.Router(),
    temporadas = require("../models/temporadas");

router.get("/", function(req, res) {
    temporadas.find({}, function(err, data) {
        if (err) {
            res.send("error");
            return;
        }
        res.send(data);
    });
});

router.get("/:id", function(req, res) {
    var id = req.params.id;
    temporadas.find({ _id: id }, function(err, data) {
        if (err) {
            res.send("error");
            return;
        }
        res.send(data[0]);
    });
});

router.post("/", function(req, res) {
    var obj = req.body;
    var model = new temporadas(obj);
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

    temporadas.findByIdAndUpdate(id, { temporada_id: obj.temporada_id, temporada_numero: obj.temporada_numero, ator_id: obj.ator_id,nome: obj.nome },
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
    temporadas.findByIdAndRemove(id, function(err) {
        if (err) {
            res.send("error");
            return;
        }
        res.send("deleted");
    });
});

router.post("/:id/ator/:ator", function(req, res) {
    var id = req.params.id;
    var atorid = req.params.ator;

    series.findOne({_id: id}, function(err, data) {
        if (err) {
            res.send("error");
            return;
        }

        data.temporada_id.addToSet(atorid);
        data.save(function (err) {
            if (err) {
                res.send("error");
                return;
            }

            res.send(data)
        })
    });
});

router.delete("/:id/ator/:ator", function(req, res) {
    var id = req.params.id;
    var atorId = req.params.temporada;


    series.findOne({_id: id}, function(err, data) {
        if (err) {
            res.send("error");
            return;
        }

        data.temporada_id(atorId).remove();

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