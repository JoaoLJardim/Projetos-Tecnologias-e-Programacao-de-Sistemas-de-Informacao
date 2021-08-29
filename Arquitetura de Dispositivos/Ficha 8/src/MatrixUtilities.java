public class MatrixUtilities {

    public static String show(int[][] matrix) {
        StringBuilder str = new StringBuilder();
        for (int[] ints : matrix) {
            str.append("\n[");
            for (int anInt : ints) {
                str.append(anInt).append(",");
            }
            str.replace(str.lastIndexOf(","),str.lastIndexOf(",")+1,"");
            str.append("]");
        }

        return str.toString();
    }

    public static boolean isMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
                if (ints.length != matrix[0].length)
                    return false;
        }
        return true;
    }

    public static boolean isIdentity(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] array = matrix[i];
            if (array[i] != 1)
                return false;

            for (int i1 = 0; i1 < array.length; i1++) {
                if (array[i1] != 0 && i1 != i){
                    return false;
                }
            }
        }

        return true;
    }

    public static int[][] multiplyBy(int[][] matrix, int a) {
        int[][] res = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                res[i][i1] = (matrix[i][i1] * a);
            }
        }

        return res;
    }

    public static boolean areCompatibleForSum(int[][] matrix,int[][] matrix1) {
        int lenght = matrix[0].length;
        if (matrix.length != matrix1.length)
            return false;

        for (int[] ints : matrix) {
            if (ints.length != lenght)
                return false;
        }
        for (int[] ints : matrix1) {
            if (ints.length != lenght)
                return false;
        }
        return true;
    }

    public static int[][] sumOf(int[][] matrix, int[][] matrix2) {
        if (!areCompatibleForSum(matrix,matrix2))
            return null;

        int[][] res = new int[matrix.length][matrix[0].length];


        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                res[i][i1] = (matrix[i][i1] + matrix2[i][i1]);
            }
        }

        return res;
    }
}
