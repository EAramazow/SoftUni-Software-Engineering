package MultidimensionalArray.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.trim().split(" ")[0]);
        int cols = Integer.parseInt(input.trim().split(" ")[1]);

        String[][] matrix = new String[rows][cols];
        char startLetter = 'a';

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                String palindrome = "" + startLetter + (char) (startLetter + col) + startLetter;
                matrix[row][col] = palindrome;
            }

            startLetter = (char) (startLetter + 1);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }


}
