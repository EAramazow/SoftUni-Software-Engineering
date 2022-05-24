package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String typeClass = "";
        String typeCar = "";
        double price = 0;





        if (budget <= 100) {
            typeClass = "Economy class";
            if (season.equals("Summer")) {
                typeCar = "Cabrio";
                price = budget * 0.35;
            } else {
                typeCar = "Jeep";
                price = budget * 0.65;
            }
        } else if (budget > 100 && budget <= 500) {
            typeClass = "Compact class";
            if (season.equals("Summer")) {
                typeCar = "Cabrio";
                price = budget * 0.45;
            } else {
                typeCar = "Jeep";
                price = budget * 0.80;
            }
        } else if (budget > 500) {
            typeClass = "Luxury class";
            typeCar = "Jeep";
            price = budget * 0.90;
        }

        System.out.printf("%s\n%s - %.2f", typeClass, typeCar, price);
    }
}
