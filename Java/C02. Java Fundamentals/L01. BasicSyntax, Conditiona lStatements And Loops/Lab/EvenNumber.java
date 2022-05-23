package basicSyntaxConditionalStatementsLoops.Lab;

import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());


        while (true) {
            if (number % 2 == 0) {
                System.out.printf("The number is: %d", Math.abs(number));
                break;
            } else {
                System.out.printf("Please write an even number.\n", number);
            }


            number = Integer.parseInt(scanner.nextLine());
        }

    }
}

