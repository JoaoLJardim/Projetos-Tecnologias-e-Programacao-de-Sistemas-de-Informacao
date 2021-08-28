var arrayUtils = {
    isEmpty: function (array) {
        if (array.length == 0) {
            return true;
        } else {
            return false;
        }
    },
    max: function (array) {
        var max = array[0];
        for (let i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i]
            }
        }
        return max;
    },
    min: function (array) {
        var min = array[0];
        for (let i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i]
            }
        }
        return min;
    },
    average: function (array) {
        var count = 0;
        var media = 0;
        for (let i = 0; i < array.length; i++) {
            count+=array[i];
        }
        media = (count) / array.length;
        return media;
    },
    indexOf: function (array, value) {
        var index = -1;
        for (let i = 0; i < array.length; i++) {
            if (array[i] == value) {
                index = i;
            }
        }
        return index;
    },
    subArray: function (array, startIndex, endIndex) {
        var subArray = [];
        for (let i = startIndex; i < endIndex; i++) {
            subArray.push(array[i])
        }
        return subArray
    },
    isSameLength: function (array1, array2) {
        if (array1.length == array2.length) {
            return true;
        } else {
            return false;
        }
    },
    reverse: function (array) {
        var inverted = [];
        for (let i = array.length-1; i >= 0; i--) {
            inverted.push(array[i])
        }
        return inverted;
    },
    swap : function (array,index1,index2) {
        var aux = array[index1];
        array[index1] = array[index2];
        array[index2] = aux;
        return array;
        
    },
    contains: function (array,value) {
        if(!this.isEmpty(array)){
            var index = this.indexOf(array,value) !=-1;
            return index;
        }else{
            return false;
        }
    },
    concatenate: function (array1,array2) {
        var array = array1;
        for (let i = 0; i < array2.length; i++) {
            array.push(array2[i])    
        }
        return array
    }
};

module.exports = arrayUtils;