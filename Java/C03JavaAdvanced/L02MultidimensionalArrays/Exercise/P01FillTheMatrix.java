package MultidimensionalArray.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rowsAndCols = Integer.parseInt(input.trim().split(", ")[0]);
        String typeOfPattern = input.trim().split(", ")[1];

        if (typeOfPattern.equals("A")) {

            patternA(rowsAndCols);
            printMatrix(patternA(rowsAndCols));

        } else if (typeOfPattern.equals("B")) {

            patternB(rowsAndCols);
            printMatrix(patternB(rowsAndCols));

        }


    }

    private static int[][] patternB(int rowsAndCols) {
        int start = 1;
        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = start++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = start++;
                }
            }
        }
        return matrix;
    }


    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int e : arr) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    private static int[][] patternA(int rowsAndCols) {

        int start = 1;
        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = start++;

            }
        }
        return matrix;
    }

}
