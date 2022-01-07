package MultidimensionalArray.Lab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char [][] firstMatrix = readMatrix(rows, cols, scanner);
        char [][] secondMatrix = readMatrix(rows, cols, scanner);

        char [][] outputMatrix = new char[rows][cols];

         // тъй като е опоменато, че матриците са еднакви, можем да ги обходим само по редовете,
        // а не по firstMatrix.length

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // използваме тернарен оператор
               // char fillChar = true or false ? true : false

                char fillChar = firstMatrix[row][col] == secondMatrix[row][col]
                        ? firstMatrix[row][col] : '*';

                outputMatrix[row][col] = fillChar;
            }
        }

        // за да отпечатаме всеки един елемент - два фор цикъла по ред и колона

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(outputMatrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    // метод за прочитане на char матрица от конзолата

    public static char [][] readMatrix (int rows, int cols, Scanner scanner) {

        char [][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine();
            String[] elements =  line.trim().split("\\s+");


            for (int i = 0; i < elements.length; i++) {
                char current = elements[i].charAt(0);
                matrix[row][i] = current;
            }
        }

        return matrix;

    }
}
