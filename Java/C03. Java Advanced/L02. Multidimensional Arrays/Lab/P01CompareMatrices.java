package MultidimensionalArray.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);
        int [][] firstMatrix = readMatrix(rows, scanner);


        rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);
        int [][] secondMatrix = readMatrix(rows, scanner);

        boolean areEqual = areEqualMatrices(firstMatrix, secondMatrix);

        String output = areEqual ? "equal" : "not equal";
        System.out.println(output);

    }

    public static int[] [] readMatrix (int rows, Scanner scanner) {
        int [][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    public static boolean areEqualMatrices (int [][] firstMatrix, int [][] secondMatrix ) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];

            if (firstArr.length != secondArr.length) {
                return false;
            }

            for (int col = 0; col < firstArr.length; col++) {
                if (firstArr[col] != secondArr[col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
