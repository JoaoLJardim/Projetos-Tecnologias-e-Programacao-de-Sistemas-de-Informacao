const Sequelize = require('sequelize');
const CustomerModel = require('./models/customer');
const OrderModel = require('./models/order');

const sequelize = new Sequelize(process.env.DB_SCHEMA,process.env.DB_USER,process.env.DB_PASS,{
    host: process.env.DB_HOST,
    dialect: 'mysql',
    pool:{
        max:10,
        min: 0,
        acquire: 30000,
        idle: 10000
    }
});

const Customer = CustomerModel(sequelize,Sequelize);
const Order = OrderModel(sequelize,Sequelize);

sequelize.sync({ force: false })

module.exports = {
    Customer,
    Order
}