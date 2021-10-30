package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juniors = Integer.parseInt(scanner.nextLine());
        int seniors = Integer.parseInt(scanner.nextLine());
        String route = scanner.nextLine();

        double juniorPrice = 0;
        double seniorPrice = 0;
        double sum = 0;
        double discount = 0;


        switch (route) {
            case "trail":
                juniorPrice = juniors * 5.50;
                seniorPrice = seniors * 7;
                sum = juniorPrice + seniorPrice;
                break;
            case "cross-country":
                juniorPrice = juniors * 8;
                seniorPrice = seniors * 9.50;
                sum = juniorPrice + seniorPrice;
                if (juniors + seniors > 50) {
                    sum = sum - (sum * 0.25);
                }
                break;
            case "downhill":
                juniorPrice = juniors * 12.25;
                seniorPrice = seniors * 13.75;
                sum = juniorPrice + seniorPrice;
                break;
            case "road":
                juniorPrice = juniors * 20;
                seniorPrice = seniors * 21.50;
                sum = juniorPrice + seniorPrice;
                break;
        }
            discount = sum * 0.05;
                sum -= discount;

        System.out.printf("%.2f", sum);
        }

    }
