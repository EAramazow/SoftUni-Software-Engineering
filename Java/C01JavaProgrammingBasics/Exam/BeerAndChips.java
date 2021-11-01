package Exam24April2021;

import java.util.Scanner;

public class BeerAndChips {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameFootballFan = scanner.nextLine();
        double providedBudget = Double.parseDouble(scanner.nextLine());
        int beersNumber = Integer.parseInt(scanner.nextLine());
        int chipsNumber = Integer.parseInt(scanner.nextLine());


        double priceBeer = 1.20 * beersNumber;

        double priceOneChips = 0.45 * priceBeer;
        double priceChips = Math.ceil(priceOneChips * chipsNumber);

        double allSum = priceBeer + priceChips;

        if (providedBudget >= allSum) {
            System.out.printf("%s bought a snack and has %.2f leva left.", nameFootballFan,providedBudget - allSum );
        } else {
            System.out.printf("%s needs %.2f more leva!", nameFootballFan, allSum - providedBudget);
        }



    }
}
