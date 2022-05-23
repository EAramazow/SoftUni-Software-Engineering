package MultidimensionalArray.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().trim().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = readMatrix(scanner, rows, cols);

        int bestSum = Integer.MIN_VALUE;

        int resultRow, resultCol;

        int[][] bestMatrix = new int[2][2];

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {


                int current = matrix[row][col];
                int right = matrix[row][col + 1];
                int bottom = matrix[row + 1][col];
                int leftRight = matrix[row + 1][col + 1];

                int sum = current + right + bottom + leftRight;

                if (sum > bestSum) {
                    bestSum = sum;
                    bestMatrix = new int[][] {
                            {current, right},
                            {bottom, leftRight}
                    };
                }
            }
        }
        printMatrix(bestMatrix);
        System.out.println(bestSum);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().trim().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
