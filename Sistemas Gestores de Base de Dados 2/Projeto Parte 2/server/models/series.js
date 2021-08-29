var mongoose = require("mongoose"),
    Schema = mongoose.Schema,
    objectId = mongoose.Schema.ObjectId;

var diretorSchema = require('./diretore');

var serieSchame = new Schema({
    _id: {type: objectId, auto: true},
    serie_id: {type: Number, required: true},
    nome: {type: String, required: true},
    data: {type: Date, required: true},
    rating: {type: Number, required: true},
    temporada_id: {type: [Number], required: true},
    diretores: [diretorSchema]
}, {versionKey: false});

var serieModel = mongoose.model('Series', serieSchame, 'series');

module.exports = serieModel;