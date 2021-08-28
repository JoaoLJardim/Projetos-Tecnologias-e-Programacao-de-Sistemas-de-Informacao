
module.exports = (sequelize, type) => {
    return sequelize.define('orders', {
        comments: type.TEXT,
        customerNumber: type.INTEGER,
        orderDate: type.DATE,
        orderNumber: {type: type.INTEGER, primaryKey: true},
        requiredDate: type.DATE,
        shippedDate: type.DATE,
        status: type.STRING
    },
    {
        timestamps: false
    }
    )
}