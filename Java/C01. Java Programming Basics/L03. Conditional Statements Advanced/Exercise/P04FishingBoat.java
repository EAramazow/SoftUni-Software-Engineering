package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P04FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int numberFishers = Integer.parseInt(scanner.nextLine());

        int loanBoat = 0;
        double sumWithDiscount = 0;

        switch (season) {
            case "Spring":
                loanBoat = 3000;
                if (numberFishers <= 6) {
                    sumWithDiscount = loanBoat * 0.9;
                } else if (numberFishers >= 6 && numberFishers <= 11) {
                    sumWithDiscount = loanBoat * 0.85;
                } else if (numberFishers >= 12) {
                    sumWithDiscount = loanBoat * 0.75;
                }
                break;

            case "Summer":
            case "Autumn":
                loanBoat = 4200;
                if (numberFishers <= 6) {
                    sumWithDiscount = loanBoat * 0.9;
                } else if (numberFishers >= 6 && numberFishers <= 11) {
                    sumWithDiscount = loanBoat * 0.85;
                } else if (numberFishers >= 12) {
                    sumWithDiscount = loanBoat * 0.75;
                }
                break;

            case "Winter":
                loanBoat = 2600;

                if (numberFishers <= 6) {
                    sumWithDiscount = loanBoat * 0.9;
                } else if (numberFishers >= 6 && numberFishers <= 11) {
                    sumWithDiscount = loanBoat * 0.85;
                } else if (numberFishers >= 12) {
                    sumWithDiscount = loanBoat * 0.75;
                }
                break;
        }

        if (numberFishers % 2 == 0 && !season.equals("Autumn")) {
            sumWithDiscount = sumWithDiscount * 0.95;

        }

        if (budget >= sumWithDiscount) {
            System.out.printf("Yes! You have %.2f leva left.", budget - sumWithDiscount);
        } else if (budget < sumWithDiscount) {
            System.out.printf("Not enough money! You need %.2f leva.", Math.abs(budget - sumWithDiscount));
        }


    }
}


