package MultidimensionalArray.Lab;

public class IsInBoundsMethod {


    public static boolean isInBound (int row, int col, int[][] matrix) {
        return row < matrix.length && row >= 0
                && col < matrix[row].length && col >= 0;
    }


    public static boolean isOutOfBounds (int row, int col, int [][] matrix) {
        return !isInBound(row, col, matrix);
    }
}
