var mongoose = require("mongoose"),
    Schema = mongoose.Schema,
    objectId = mongoose.Schema.ObjectId;

var episodiosSchame = new Schema({
    _id: {type: objectId, auto: true},
    nome: {type: String, required: true},
    ator_id: {type: Number, required: true},
    idade: {type: Number, required: true},
    telefone: {type: Number, required: true}
}, {versionKey: false});

var episodiosModel = mongoose.model('Atores', episodiosSchame, 'atores');

module.exports = episodiosModel;