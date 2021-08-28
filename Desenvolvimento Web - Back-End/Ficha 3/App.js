var ArrayUtils = require("./ArrayUtils.js");

function started() {
    console.log("Started Download");
}

function update(percentagem) {
    console.log(percentagem+"% of Download")
}

function completed() {
    console.log("Compleated Download")   
}

function performDownload(startedFn,updateFn,completedFn) {
    startedFn();
    for (let i = 0; i <= 100; i++) {
        updateFn(i)
    }
    completedFn();
}

performDownload(started,update,completed)

console.log(ArrayUtils.isEmpty([]));
console.log(ArrayUtils.max([1,5,6,7,1,2,6,19]));
console.log(ArrayUtils.min([1,5,6,7,1,2,6,19]));
console.log(ArrayUtils.average([1,5,6,7,1,2,6,19]))
console.log(ArrayUtils.indexOf([1,5,6,7,1,2,6,19],2));
console.log(ArrayUtils.subArray([1,5,6,7,1,2,6,19],2,4));
console.log(ArrayUtils.isSameLength([1,5,6,7,1,2,6,19],[1,5,6,7,2,6,19]));
console.log(ArrayUtils.reverse([1,5,6,7,1,2,6,19]));
console.log(ArrayUtils.swap([1,5,6,7,1,2,6,19],1,6));
console.log(ArrayUtils.contains([1,5,6,7,1,2,6,19],122));
console.log(ArrayUtils.concatenate([1,5,6,7,1,2,6,19],[1,5,6,7,1,2,6,19]));