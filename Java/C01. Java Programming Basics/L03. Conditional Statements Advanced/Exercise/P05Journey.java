package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P05Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();


        String destination = "";
        String sleeping = "";
        double sum = 0;


        switch (season) {
            case "summer":
            if (budget <= 100) {
                destination = "Bulgaria";
                sleeping = "Camp";
                sum = budget * 0.3;
            } else if (budget <= 1000) {
                destination = "Balkans";
                sleeping = "Camp";
                sum = budget * 0.4;
            } else if (budget > 1000) {
                destination = "Europe";
                sleeping = "Hotel";
                sum = budget * 0.9;
            }
                break;


            case "winter":
                if (budget <= 100) {
                    destination = "Bulgaria";
                    sleeping = "Hotel";
                    sum = budget * 0.7;
                } else if (budget <= 1000) {
                    destination = "Balkans";
                    sleeping = "Hotel";
                    sum = budget * 0.8;
                } else if (budget > 1000) {
                    destination = "Europe";
                    sleeping = "Hotel";
                    sum = budget * 0.9;
                }
                break;

        }
        System.out.printf("Somewhere in %s", destination);
        System.out.printf("\n%s - %.2f", sleeping, sum);
    }
}
