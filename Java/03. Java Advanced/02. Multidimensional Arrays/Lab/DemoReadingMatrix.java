package MultidimensionalArray.Lab;

import java.util.Scanner;

public class DemoReadingMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        int [] [] matrix = new int [rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] inputTokens = scanner.nextLine().split("\\s+");

            for (int column = 0; column < cols; column++) {
                matrix [row][column] = Integer.parseInt(inputTokens[column]);
            }
        }

    }
}
