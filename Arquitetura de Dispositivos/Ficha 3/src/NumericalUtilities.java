public class NumericalUtilities {

    public static int powerOf(int base, int exp) {
        int res = 0;
        for (int i = 1; i < exp; i++)
            res = res + base * base;
        return res;
    }

    public static int sumOfNaturalNumbersUpTo(int i) {
        int res = 0;
        for (int j = 0; j <= i; j++) {
            res = res + j;
        }
        return res;
    }

    public static int sumOfNaturalNumbersBetween(int i, int i1) {
        int res = 0;
        for (int j = i; j < i1; j++) {
            res = res + j;
        }
        return res;
    }

    public static int sumOfEvenNumbersBetween(int i, int i1) {
        int res = 0;
        for (int j = i; j < i1; j++) {
            if ((j % 2) == 0) {
                res = res + j;
            }
        }
        return res;
    }

    public static int numberOfDivisorsOf(int n) {
        int res = 0;
        for (int j = n; j != 0; j--) {
            if ((n % j) == 0) {
                res = res + 1;
            }
        }
        return res;
    }

    public static boolean isPrime(int i) {
        if (numberOfDivisorsOf(i) == 2)
            return true;
        else
            return false;
    }
}
