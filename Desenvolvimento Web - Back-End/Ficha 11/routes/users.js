var express = require('express');
var usersController = require('../controllers/usersController');
var jwt = require('jsonwebtoken');
var router = express.Router();

router.get('/',authenticateTokenFromSession, usersController.getUsers);

router.put('/',authenticateTokenFromSession, usersController.setUsers);

router.delete('/:id',authenticateTokenFromSession, usersController.deleteUser);

router.get('/:id',authenticateTokenFromSession, usersController.ShowUser);

router.post('/:id',authenticateTokenFromSession,usersController.UpdateUser);

function authenticateTokenFromSession(req,res,next) {
  const token = req.session.token;
  if(token == null){
    // Unauthorized
    return res.sendStatus(401)
  }else{
    jwt.verify(token,process.env.TOKEN_SECRET,function (err,user) {
      if(err){
        // Forbidden
        return res.sendStatus(403)
      }
      // Token e valido, logo continuamos
      next();
    })
  }
}

function auchenticateTokenFromHeaders(req,res,next) {
  const authHeader = req.headers['authorization'];
  const token = authHeader && authHeader.split('-');

  if (token == null) return res.sendStatus(401);
  jwt.verify(token,process.env.TOKEN_SECRET,(err,user)=>{
    if (err)
    return res.sendStatus(403);
    req.user = user;
    next;
  })
}
module.exports = router;
