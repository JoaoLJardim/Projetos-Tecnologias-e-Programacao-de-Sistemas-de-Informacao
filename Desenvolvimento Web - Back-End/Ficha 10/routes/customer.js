var express = require('express');
var router = express.Router();
var CustommerController = require('../controllers/CustomerController');


router.get('/', CustommerController.getall);

router.post('/', CustommerController.add);

router.delete('/:id', CustommerController.deleteUser);

router.get('/:id', CustommerController.getuser);

router.get('/:cid/orders/:oid', CustommerController.getorder);



module.exports = router;

