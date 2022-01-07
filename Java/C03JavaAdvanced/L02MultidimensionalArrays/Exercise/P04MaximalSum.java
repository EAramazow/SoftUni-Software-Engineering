package MultidimensionalArray.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        int[][] matrix = readMatrix(scanner, rows, cols);

        int bestSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;


        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {

                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (sum > bestSum) {
                    bestSum = sum;
                    startRow = row;
                    startCol = col;
                }

            }
        }
        System.out.println("Sum = " + bestSum);

        printMatrix(matrix, startRow, startCol);

    }

    private static void printMatrix(int[][] matrix, int startRow, int startCol) {
        for (int row = startRow; row <= startRow + 2; row++) {
            for (int col = startCol; col <= startCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }


    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().trim().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}

