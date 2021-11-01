package basicSyntaxConditionalStatementsLoops.Exercise;

import java.util.Locale;
import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sumCoins = 0.0;

        while (!input.equals("Start")) {

            double enteredCoin = Double.parseDouble(input);

            if (enteredCoin == 0.3 || enteredCoin == 0.4 || enteredCoin == 0.6
                    || enteredCoin == 0.7 || enteredCoin == 0.8 || enteredCoin == 0.9) {
                System.out.printf("Cannot accept %.2f\n", enteredCoin);
            } else {
                sumCoins += enteredCoin;

            }

            input = scanner.nextLine();

        }

        String secondInput = scanner.nextLine();

        double nutsPrice = 2;
        double waterPrice = 0.7;
        double crispsPrice = 1.5;
        double sodaPrice = 0.8;
        double cokePrice = 1;

        while (!secondInput.equals("End")) {

            switch (secondInput) {
                case "Nuts":
                    if (sumCoins >= nutsPrice) {
                        System.out.println("Purchased Nuts");
                        sumCoins -= nutsPrice;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (sumCoins >= waterPrice) {
                        System.out.println("Purchased Water");
                        sumCoins -= waterPrice;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (sumCoins >= crispsPrice) {
                        System.out.println("Purchased Crisps");
                        sumCoins -= crispsPrice;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (sumCoins >= sodaPrice) {
                        System.out.println("Purchased Soda");
                        sumCoins -= sodaPrice;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (sumCoins >= cokePrice) {
                        System.out.println("Purchased Coke");
                        sumCoins -= cokePrice;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }


            secondInput = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sumCoins);

    }
}