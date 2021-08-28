const Sequelize = require('sequelize');
const UserModel = require('./models/user');

const sequelize = new Sequelize(process.env.DB_SCHEMA, process.env.DB_USER, process.env.DB_PASS, {
    host: 'localhost',
    dialect: 'mysql',
    pool: {
        max: 10,
        min: 0,
        acquire: 30000,
        idle: 10000
    }
});

const User = UserModel(sequelize, Sequelize);

sequelize.sync({ force: true })
    .then(() => {
        console.log("Tables Created!");
        User.bulkCreate([
            { email: "tendi@gmail.com", password: "tendi" },
            { email: "tendi2@gmail.com", password: "tendi2" },
            { email: "tendi3@gmail.com", password: "tendi3" }
        ])
            .then(() => {
                return User.findAll();
            })
            .then((users) => {
                console.log(users)
            })
    });

module.exports = {
    User
}