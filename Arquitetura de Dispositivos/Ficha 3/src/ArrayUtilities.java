import java.util.ArrayList;

public class ArrayUtilities {


    public static String toString(int[] nums) {
        String builder = "[";
        for (int value : nums) {
            builder = builder + value + ",";
        }
        builder = builder + "]";
        builder = builder.replace(",]", "]");
        return builder;
    }

    public static int maximumOf(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (res < nums[i])
                res = nums[i];
        }
        return res;
    }

    public static int minimumOf(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (res > nums[i])
                res = nums[i];
        }
        return res;
    }

    public static int[] copyOf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public static boolean contains(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num)
                return true;
        }
        return false;
    }

    public static boolean containsDuplicates(int[] array) {
        int[] dup = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (contains(dup, array[i])) {
                return true;
            }
            dup[i] = array[i];
        }
        return false;
    }

    public static int indexOf(int[] array, int i) {
        int res = -1;
        for (int i1 = 0; i1 < array.length; i1++) {
            if (i == array[i1]) {
                res = i1;
            }
        }
        return res;
    }

    public static int[] add(int[] array, int i) {
        int[] res = new int[array.length + 1];
        for (int j = 0; j < array.length; j++) {
            res[j] = array[j];
        }

        res[array.length] = i;
        return res;
    }

    public static int[] remove(int[] array, int i) {
        if (contains(array, i)) {
            int[] res = new int[0];
            for (int j = 0; j < array.length; j++) {
                if (array[j] != i) {
                    res = add(res, array[j]);
                }
            }
            return res;
        }
        return array;
    }

}
