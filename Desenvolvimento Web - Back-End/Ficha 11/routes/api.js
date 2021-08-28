var express = require('express');

var apiController = require('../controllers/apiController');
var router = express.Router();

router.get('/',apiController.getApi);

module.exports = router;