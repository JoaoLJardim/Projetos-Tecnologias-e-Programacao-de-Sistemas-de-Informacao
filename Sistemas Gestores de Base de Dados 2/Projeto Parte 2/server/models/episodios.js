var mongoose = require("mongoose"),
    Schema = mongoose.Schema,
    objectId = mongoose.Schema.ObjectId;

var episodiosSchame = new Schema({
    _id: {type: objectId, auto: true},
    nome: {type: String, required: true},
    temporada_id: {type: Number, required: true},
    episodio_numero: {type: Number, required: true}
}, {versionKey: false});

var episodiosModel = mongoose.model('Episodios', episodiosSchame, 'episodios');

module.exports = episodiosModel;