package MultidimensionalArray.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(scanner, size);

        int primaryDiagonalSum = primaryDiagonal(matrix, size);

        int secondaryDiagonalSum = secondaryDiagonal(matrix, size);

        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));


    }

    private static int secondaryDiagonal(int[][] matrix, int size) {
        int row = size;
        int col = 0;
        int currentSum = 0;

        while (row >= 0 && col < size) {
            currentSum += matrix[row - 1][col];
            row--;
            col++;
        }
        return currentSum;
    }

    private static int primaryDiagonal(int[][] matrix, int size) {
        int currentSum = 0;
        int row = 0;
        int col = 0;

        while (row < size && col < size) {
            currentSum += matrix[row][col];
            row++;
            col++;
        }
        return currentSum;
    }

    private static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().trim().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;

    }
}
