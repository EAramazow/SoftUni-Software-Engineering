package basicSyntaxConditionalStatementsLoops.Exercise;

import java.util.Scanner;

public class P06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int startNumber = number;

        while (number != 0) {
            int lastNum = number % 10;

            int factorial = 1;

            for (int i = 1; i <= lastNum; i++) {
                factorial = factorial * i;

            }

            sum += factorial;

            number = number / 10;
        }

        if (startNumber == sum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}

