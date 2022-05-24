package basicSyntaxConditionalStatementsLoops.Lab;

import java.util.Scanner;

public class MultiplicationTable1SecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int multiplier = 1;

        while (multiplier <= 10) {

            System.out.printf("%d X %d = %d%n", num, multiplier, num * multiplier);
            multiplier++;
        }
    }
}
