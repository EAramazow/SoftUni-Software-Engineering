package ConditionalStatements.Exercise;

import java.util.Scanner;

public class P06GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budgetMovie = Double.parseDouble(scanner.nextLine());
        int actors = Integer.parseInt(scanner.nextLine());
        double clothesPrice = Double.parseDouble(scanner.nextLine());

        double decor = budgetMovie * 0.1;

        if (actors > 150) {
            clothesPrice = clothesPrice - clothesPrice*0.1;

            // clothesPrice може да се напише и като :
            // clothesPrice *= 0.9;
        }

        double neededMoney = actors * clothesPrice + decor;
        double difference = Math.abs(neededMoney - budgetMovie);

        if (neededMoney > budgetMovie) {
            System.out.printf("Not enough money!\n" +
                    "Wingard needs %.2f leva more.", difference);

            // \n - премести курсора на нов ред

        } else if (neededMoney <= budgetMovie) {
            System.out.printf("Action!\n" +
                    "Wingard starts filming with %.2f leva left.", difference);
        }
    }
}
