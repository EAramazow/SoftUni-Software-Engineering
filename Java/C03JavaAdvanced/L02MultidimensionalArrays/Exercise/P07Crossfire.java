package MultidimensionalArray.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rows, cols);

        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {
            String[] splitCommand = command.trim().split("\\s+");
            int row = Integer.parseInt(splitCommand[0]);
            int col = Integer.parseInt(splitCommand[1]);
            int radius = Integer.parseInt(splitCommand[2]);


            for (int i = row - radius; i <= row + radius; i++) {
                if (isValidMatrixBounds(i, col, matrix) && i != row) {
                    matrix.get(i).remove(col);
                }
            }

            for (int i = col + radius; i >= col - radius; i--) {
                if (isValidMatrixBounds(row, i, matrix)) {
                    matrix.get(row).remove(i);
                }
            }

            matrix.removeIf(List::isEmpty);

            command = scanner.nextLine();
        }

        printMatrix(matrix);

    }


    public static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMatrixBounds(int row, int col, List<List<Integer>> matrix) {
        return row < matrix.size() && row >= 0 && col < matrix.get(row).size() && col >= 0;

    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {

        int startNumber = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(startNumber++);
            }
        }
    }
}
