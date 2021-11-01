package basicSyntaxConditionalStatementsLoops.Lab;

import java.util.Scanner;

public class MultiplicationTable2SecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        if (multiplier <= 10) {
            while (multiplier <= 10) {
                System.out.printf("%d X %d = %d%n", number, multiplier, number * multiplier);
                multiplier++;
            }
            } else {
            System.out.printf("%d X %d = %d%n", number, multiplier, number * multiplier);

        }
    }
}
