package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberChrysanthemums = Integer.parseInt(scanner.nextLine());
        int numberRoses = Integer.parseInt(scanner.nextLine());
        int numberTulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holiday = scanner.nextLine();

        double chrysanthemumsPrice = 0;
        double rosesPrice = 0;
        double tulipsPrice = 0;
        double allSum = 0;

        switch (season) {

            case "Spring":
            case "Summer":
                chrysanthemumsPrice = numberChrysanthemums * 2;
                rosesPrice = numberRoses * 4.10;
                tulipsPrice = numberTulips * 2.50;
                break;

            case "Autumn":
            case "Winter":
                chrysanthemumsPrice = numberChrysanthemums * 3.75;
                rosesPrice = numberRoses * 4.50;
                tulipsPrice = numberTulips * 4.15;
                break;

        }

        allSum = chrysanthemumsPrice + rosesPrice + tulipsPrice;

        if (holiday.equals("Y")) {
            allSum = allSum * 1.15;
        }

        if (numberTulips >= 7 && season.equals("Spring")) {
            allSum = allSum * 0.95;
        }
        if (numberRoses >= 10 && season.equals("Winter")) {
            allSum = allSum * 0.9;
        }
        if (numberRoses + numberTulips + numberChrysanthemums >= 20) {
            allSum = allSum * 0.8;
        }

        System.out.printf("%.2f", allSum + 2);
    }

}
