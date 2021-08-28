
module.exports = (sequelize, type) => {
    return sequelize.define('customers', {
        customerNumber:{type: type.INTEGER, primaryKey: true},
        customerName: type.STRING,
        contactLastName: type.STRING,
        contactFirstName: type.STRING,
        phone: type.STRING,
        addressLine1: type.STRING,
        addressLine2:  type.STRING,
        city: type.STRING,
        state: type.STRING,
        postalCode: type.STRING,
        country: type.STRING,
        salesRepEmployeeNumber:  type.INTEGER,
        creditLimit: type.DECIMAL
    },
    {
        timestamps: false
    }
    )
}