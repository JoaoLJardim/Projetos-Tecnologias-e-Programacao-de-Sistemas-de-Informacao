// TODO Implement all the models and business logic using sequelize
const Sequelize = require('sequelize');
const PersonModel = require('./models/user');

const sequelize = new Sequelize('Ficha13','root','',{
    host: 'localhost',
    dialect: 'mysql',
    pool:{
        max:10,
        min: 0,
        acquire: 30000,
        idle: 10000
    }
});

const User = PersonModel(sequelize,Sequelize);

sequelize.sync({ force: false })
    .then(() => {
        console.log("Tables Created!");
        User.bulkCreate([
            { email: "David@hotmail.com", password: "ola"},
            { email: "jotmfgaming@gmail.com", password: "ola"},
        ])
            .then(() => {
                return User.findAll();
            })
            .then((persons) => {
                console.log(persons)
            })
    });

module.exports = {
    User
}