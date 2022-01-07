package MultidimensionalArray.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // създавам масив за да прочета данните

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();


        // прочитам редове и колони от масива

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        // създавам матрица с броя на редовете и колоните

        int[][] matrix = new int[rows][cols];

        // прочитам матрицата от конзолата според редовете

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // числото, което трябва да намеря

        int numberToSearch = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        // обхождам матрицата по редове и колони (обхващам цялата матрица)

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == numberToSearch) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }


        System.out.println();
    }
}
