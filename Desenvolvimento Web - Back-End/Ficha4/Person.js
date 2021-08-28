function Person(firstname,lastname) {
    this.firstname=firstname;
    this.lastname=lastname;
}

Person.prototype.greet= function() {
    console.log("Hello " + this.firstname +" "+ this.lastname + " " + this.age);   
}

Person.prototype.age=0;
var john = new Person("João","Jardim");
john.age=19;
var mary = new Person("Maria","Pessoa");
mary.age=12;

console.log(john.age)
console.log(mary.age)

john.greet();
mary.greet();

console.log(john.__proto__);
console.log(mary.__proto__);
console.log(john.__proto__==mary.__proto__);