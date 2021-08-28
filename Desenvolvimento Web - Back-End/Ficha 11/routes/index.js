var express = require('express');
var indexController = require('../controllers/indexController');
var jwt = require('jsonwebtoken');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.get('/login', function(req, res, next) {
  res.render('login', { message: req.flash('loginMessage') });
});

router.get('/profile',authenticateTokenFromSession, function(req, res) {
  res.render('profile.ejs', {
    user: req.session.user
  });
});

router.post('/login', indexController.login);

router.get('/signup', function(req, res, next) {
  res.render('signup', { message: req.flash('signupMessage') });
});

router.post('/signup', indexController.signup);

router.get('/logout',function (req,res) {
  req.session.destroy();
  res.redirect('/');
});


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

module.exports = router;
