public class Main {

    public static int[][] matrix = {
            {1,7,8,3,2},
            {4,8,2,7,4},
            {2,6,2,7,8},
            {8,9,3,6,5}
    };

    public static int[][] matrix2 = {
            {7,8,8,3,2},
            {4,2,2,7,6},
            {2,5,7,9,7},
            {1,2,3,6,9}
    };

    public static int[][] notMatrix = {
            {1,7,8,3},
            {4,8,2,7,4},
            {2,6,},
            {8,9,3}
    };

    public static int[][] matrizIdentidade = {
            {1,0,0,0,0},
            {0,1,0,0,0},
            {0,0,1,0,0},
            {0,0,0,1,0}
    };

    public static void main(String[] args) {
//        System.out.println(MatrixUtilities.show(matrix));
//        System.out.println(MatrixUtilities.isMatrix(matrix));
//        System.out.println(MatrixUtilities.isIdentity(matrizIdentidade));
//        System.out.println(MatrixUtilities.show(MatrixUtilities.multiplyBy(matrix, 5)));
//        System.out.println(MatrixUtilities.areCompatibleForSum(matrix,matrix2));
//        System.out.println(MatrixUtilities.show(MatrixUtilities.sumOf(matrix, matrix2)));

        CharacterDrawingUtilities.drawFilledRectangleWith(5,4,'+');
        System.out.println("\n");
        CharacterDrawingUtilities.drawEmptyRectangleWith(5,4,'+');
    }
}
