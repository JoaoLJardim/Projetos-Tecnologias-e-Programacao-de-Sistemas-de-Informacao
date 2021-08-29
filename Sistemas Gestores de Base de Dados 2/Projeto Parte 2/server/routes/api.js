var express = require('express'),
    router = express.Router();

//routes for user api

router.use("/atores", require("../controllers/atores.api"));
router.use("/episodios", require("../controllers/episodios.api"));
router.use("/series", require("../controllers/series.api"));
router.use("/temporadas", require("../controllers/temporadas.api"));
//add here other api routes

module.exports = router;