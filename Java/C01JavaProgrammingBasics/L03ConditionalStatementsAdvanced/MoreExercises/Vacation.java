package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();


        String location = "";
        String placeToSleep = "";
        double price = 0;

        if (budget <= 1000) {
            placeToSleep = "Camp";
            if (season.equals("Summer")) {
                location = "Alaska";
                price = budget * 0.65;
            } else {
                location = "Morocco";
                price = budget * 0.45;
            }
        } else if (budget > 1000 && budget <= 3000) {
            placeToSleep = "Hut";
            if (season.equals("Summer")) {
                location = "Alaska";
                price = budget * 0.80;
            } else {
                location = "Morocco";
                price = budget * 0.60;
            }
        } else if (budget > 3000) {
            placeToSleep = "Hotel";
            if (season.equals("Summer")) {
                location = "Alaska";
                price = budget * 0.90;
            } else {
                location = "Morocco";
                price = budget * 0.90;
            }
        }

        System.out.printf("%s - %s - %.2f", location, placeToSleep, price);
    }
}
