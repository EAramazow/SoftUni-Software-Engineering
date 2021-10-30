package WhileLoop.MoreExercises;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int expectedSum = Integer.parseInt(scanner.nextLine());


        int firstOrSecondCounter = 0;
        int cash = 0;
        int card = 0;

        int cashCounter = 0;
        int cardCounter = 0;

        double sumCash = 0;
        double sumCard = 0;

        double allSum = 0;

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            int transactions = Integer.parseInt(input);
            firstOrSecondCounter++;

            if (firstOrSecondCounter % 2 != 0) {
                if (transactions > 100) {
                    System.out.println("Error in transaction!");
                } else {
                    cashCounter++;
                    cash += transactions;
                    System.out.println("Product sold!");
                    allSum += transactions;
                }
            }

            if (firstOrSecondCounter % 2 == 0) {
                if (transactions < 10) {
                    System.out.println("Error in transaction!");
                } else {
                    cardCounter++;
                    card += transactions;
                    System.out.println("Product sold!");
                    allSum += transactions;
                }
            }

            if (allSum >= expectedSum) {
                break;
            }

            input = scanner.nextLine();
        }

        sumCash = 1.0 * cash / cashCounter;
        sumCard = 1.0 * card / cardCounter;

        if (allSum < expectedSum) {
            System.out.println("Failed to collect required money for charity.");
        } else {
            System.out.printf("Average CS: %.2f", sumCash);
            System.out.printf("\nAverage CC: %.2f", sumCard);

        }

    }
}