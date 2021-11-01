package basicSyntaxConditionalStatementsLoops.Exercise;

import java.util.Scanner;

public class P08TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int rows = 1; rows <= number ; rows++) {

            for (int i = 1; i <= rows ; i++) {
                System.out.print(rows + " ");

            }
            System.out.println();
            }
            
        }

    }
