package dataTypesAndVariables.moreExercise;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int openCount = 0;
        int closeCount = 0;

        for (int lines = 0; lines < n; lines++) {
            String input = scanner.nextLine();

            if (input.equals("(")) {
                openCount++;
            } else if (input.equals(")")) {
                closeCount++;
            }

        }

        if (closeCount == openCount) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
