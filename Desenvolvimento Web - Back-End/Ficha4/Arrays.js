var array = [];

array.push(function () {
    return "Hello World 1";
},function () {
    return "2"
},function () {
    return "3"
});

for (let i = 0; i < array.length; i++) {
    console.log(array[i]())
}

array.forEach(element => {
    console.log(element())
});