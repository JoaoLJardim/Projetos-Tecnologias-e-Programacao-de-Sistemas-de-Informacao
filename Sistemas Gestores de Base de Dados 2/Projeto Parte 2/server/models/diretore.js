var mongoose = require("mongoose"),
    Schema = mongoose.Schema,
    objectId = mongoose.Schema.ObjectId;

var diretoresSchame = new Schema({
        _id: {type: objectId, auto: true},
        diretor_id: {type: Number, required: true},
        nome: {type: String, required: true},
        telefone: {type: Number, required: true},
        morada: {type: String, required: true}
    }
);

module.exports = diretoresSchame;