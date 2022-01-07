package MultidimensionalArray.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int angleRotation = Integer.parseInt(input.trim().split("[()]+")[1]) % 360;

        List<String> linesList = new ArrayList<>();
        int maxLength = 0;

        while (!input.equals("END")) {
            String line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }
            linesList.add(line);
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }

        int rows = linesList.size();
        int cols = maxLength;

        char[][] matrix = readMatrix(rows, cols, linesList);

        degreesRotations(angleRotation, rows, cols, matrix);

    }


    private static void degreesRotations(int angleRotation, int rows, int cols, char[][] matrix) {
        if (angleRotation == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (angleRotation == 180) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (angleRotation == 270) {

            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }

    private static char[][] readMatrix(int rows, int cols, List<String> linesList) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col < linesList.get(row).length()) {
                    matrix[row][col] = linesList.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        return matrix;
    }
}




