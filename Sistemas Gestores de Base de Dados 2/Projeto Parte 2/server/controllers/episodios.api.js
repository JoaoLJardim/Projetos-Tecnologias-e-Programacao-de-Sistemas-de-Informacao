var express = require("express"),
    router = express.Router(),
    episodios = require("../models/episodios");

router.get("/", function(req, res) {
    episodios.find({}, function(err, data) {
        if (err) {
            res.send("error");
            return;
        }
        res.send(data);
    });
});

router.get("/:id", function(req, res) {
    var id = req.params.id;
    episodios.find({ _id: id }, function(err, data) {
        if (err) {
            res.send("error");
            return;
        }
        res.send(data[0]);
    });
});

router.post("/", function(req, res) {
    var obj = req.body;
    var model = new episodios(obj);
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

    episodios.findByIdAndUpdate(id, { nome: obj.nome, temporada_id: obj.temporada_id, episodio_numero: obj.episodio_numero },
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
    episodios.findByIdAndRemove(id, function(err) {
        if (err) {
            res.send("error");
            return;
        }
        res.send("deleted");
    });
});

module.exports = router;