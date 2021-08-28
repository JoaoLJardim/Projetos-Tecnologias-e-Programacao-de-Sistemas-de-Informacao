const User = require('../sequelize').User;
var jwt = require('jsonwebtoken');

exports.signup = function (req,res) {

    var {email} = req.body;
    var {password} = req.body;

    User.findOne({
        where: {
            email: email
        }
    }).then(result =>{
        if (result == null){
            User.create({'email': email,'password': password})
            .then(user => {
                req.session.user = user;
                req.session.token = generateAccessToken(email,password);
                res.redirect('/profile')
            })
        }else{
            req.flash('signupMessage','That e-mail is already taken');
            res.redirect('/signup');
        }
    }).catch(err =>{
        req.flash('signupMessage',err);
        res.redirect('/signup');
    })  
}

exports.login = function (req,res) {
    var {email} = req.body;
    var {password} = req.body;

    User.findOne({
        where: {
            email: email
        }
    }).then(result =>{
        if (result == null){
            req.flash('loginMessage','No user found with that e-mail');
            res.redirect('/login');
        }else if (password != result.password){
            req.flash('loginMessage','Wrong Password!!!');
            res.redirect('/login');
        }else{
            req.session.user = result;
            req.session.token = generateAccessToken(result.email,result.password);
            res.redirect('/profile')
        }
    }).catch(err =>{
        req.flash('loginMessage',err);
        res.redirect('/login');
    })     
}

function generateAccessToken(email,password) {
    var token = jwt.sign({email,password},process.env.TOKEN_SECRET,{expiresIn: '1800s'});
    return token;
  }