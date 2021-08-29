var mongoose = require('mongoose');
var connection = mongoose.connect('mongodb://localhost:27017/series');

module.exports = connection;