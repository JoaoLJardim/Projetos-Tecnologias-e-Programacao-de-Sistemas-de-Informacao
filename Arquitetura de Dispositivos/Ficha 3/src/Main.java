import sun.security.util.ArrayUtil;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(NumericalUtilities.powerOf(2, 3));
        System.out.println(NumericalUtilities.sumOfNaturalNumbersUpTo(20));
        System.out.println(NumericalUtilities.sumOfNaturalNumbersBetween(5, 20));
        System.out.println(NumericalUtilities.sumOfEvenNumbersBetween(5, 10));
        System.out.println(NumericalUtilities.numberOfDivisorsOf(12));
        System.out.println(NumericalUtilities.isPrime(12));

        System.out.println();

        int[] array = {3,2,5,6,4,4,5,3,2,2,5,8,9,1,2,412,1,2,2,2,2,4,4,4,4};
        System.out.println(ArrayUtilities.toString(array));
        System.out.println(ArrayUtilities.maximumOf(array));
        System.out.println(ArrayUtilities.minimumOf(array));
        System.out.println(ArrayUtilities.toString(ArrayUtilities.copyOf(array)));
        System.out.println(ArrayUtilities.contains(array,4));
        System.out.println(ArrayUtilities.containsDuplicates(array));
        System.out.println(ArrayUtilities.indexOf(array,4));

        System.out.println(ArrayUtilities.toString(ArrayUtilities.add(array, 10)));
        System.out.println(ArrayUtilities.toString(ArrayUtilities.remove(array,2)));
    }
}
