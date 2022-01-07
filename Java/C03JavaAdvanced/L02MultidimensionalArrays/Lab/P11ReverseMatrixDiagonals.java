package MultidimensionalArray.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.trim().split("\\s+")[0]);
        int cols = Integer.parseInt(input.trim().split("\\s+")[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int row = rows - 1;
        int col = cols - 1;

        while (row != -1) {
            int r = row;
            int c = col;
            while (c < cols && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if (col == -1) {
                col = 0;
                row--;
            }
        }
    }

}