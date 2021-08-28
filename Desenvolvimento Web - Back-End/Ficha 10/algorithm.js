const array = [[9,14],[1,3],[5,7],[6,8]];

function parte2(array) {
    var resultado = [];
    resultado.push(array[1]);
    for (let i = 1; i < array[2].length; i++) {
        resultado.push([array[2][0],(array[2][1]+1)]);
    }
    resultado.push(array[0]);
    console.log(resultado)
}

parte2(array);