var mongoose = require("mongoose"),
    Schema = mongoose.Schema,
    objectId = mongoose.Schema.ObjectId;

var temporadaSchame = new Schema({
    _id: {type: objectId, auto: true},
    temporada_id: {type: Number, required: true},
    ator_id: {type: [Number], required: true},
    nome: {type: String, required: true},
    temporada_numero: {type: Number, required: true}
}, {versionKey: false});

var temporadaModel = mongoose.model('Temporadas', temporadaSchame, 'temporadas');

module.exports = temporadaModel;
