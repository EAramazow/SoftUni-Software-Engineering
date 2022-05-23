package MultidimensionalArray.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensions = scanner.nextLine();

        int rows = Integer.parseInt(dimensions.trim().split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.trim().split("\\s+")[1]);

        String[][] matrix = readMatrix(scanner, rows, cols);

        String command = scanner.nextLine();

        System.out.println();

        while (!command.equals("END")) {


            // invalid command
            if (!validateCommand(command, rows, cols)) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;     // - skip everything after continue operator
            } else {
                // valid command
                String[] commandParts = command.split("\\s+");

                // "swap row1 col1 row2 col2"

                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);

                String element1 = matrix[row1][col1];
                String element2 = matrix[row2][col2];

                matrix[row1][col1] = element2;
                matrix[row2][col2] = element1;

                printMatrix(matrix);
//
            }


            command = scanner.nextLine();
        }

    }

    public static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String s : arr) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static boolean validateCommand(String command, int rows, int cols) {
        //true - if command is valid
        // false - if command is not valid

        String[] commandParts = command.split("\\s+");


        //1. if command start with "swap"
        if (!commandParts[0].equals("swap")) {
            return false;
        }

        //2. if we have exactly the same parts
        if (commandParts.length != 5) {
            return false;
        }

        //3. if the coordinates is valid (are they in the matrix)
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);

        if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows
                || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return false;
        }

        return true;
    }

    private static String[][] readMatrix(Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().trim().split("\\s+");
        }
        return matrix;
    }
}

