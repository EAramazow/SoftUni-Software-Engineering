package basicSyntaxConditionalStatementsLoops.moreExercises;

import java.util.Scanner;

public class P03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();

        double totalBalance = currentBalance;
        double spentSum = 0;
        while (!input.equals("Game Time")) {
            double price = 0;


            switch (input) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                default:
                    System.out.println("Not Found");

            }

            if (currentBalance >= price && price > 0) {
                spentSum += price;
                currentBalance -= price;
                System.out.printf("Bought %s\n", input);
            } else if (currentBalance < price && price > 0) {
                System.out.println("Too Expensive");
            }


            input = scanner.nextLine();
        }

        if (currentBalance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spentSum, totalBalance - spentSum);
        } else if (currentBalance == 0) {
            System.out.println("Out of money!");
        }
    }
}
