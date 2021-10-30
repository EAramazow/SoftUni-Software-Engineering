package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String season = scanner.nextLine();
        double kilometersPerMonth = Double.parseDouble(scanner.nextLine());


        double pricePerKilometer = 0;
        double sum = 0;

        switch (season) {
            case "Spring":
            case "Autumn":

                if (kilometersPerMonth <= 5000) {
                    pricePerKilometer = kilometersPerMonth * 0.75;
                    sum = pricePerKilometer;
                } else if (kilometersPerMonth > 5000 && kilometersPerMonth <= 10000) {
                    pricePerKilometer = kilometersPerMonth * 0.95;
                    sum = pricePerKilometer;
                } else if (kilometersPerMonth > 10000 && kilometersPerMonth <= 20000) {
                    pricePerKilometer = kilometersPerMonth * 1.45;
                    sum = pricePerKilometer;
                }
                break;

            case "Summer":
                if (kilometersPerMonth <= 5000) {
                    pricePerKilometer = kilometersPerMonth * 0.90;
                    sum = pricePerKilometer;
                } else if (kilometersPerMonth > 5000 && kilometersPerMonth <= 10000) {
                    pricePerKilometer = kilometersPerMonth * 1.10;
                    sum = pricePerKilometer;
                } else if (kilometersPerMonth > 10000 && kilometersPerMonth <= 20000) {
                    pricePerKilometer = kilometersPerMonth * 1.45;
                    sum = pricePerKilometer;
                }
                break;

            case "Winter":
                if (kilometersPerMonth <= 5000) {
                    pricePerKilometer = kilometersPerMonth * 1.05;
                    sum = pricePerKilometer;
                } else if (kilometersPerMonth > 5000 && kilometersPerMonth <= 10000) {
                    pricePerKilometer = kilometersPerMonth * 1.25;
                    sum = pricePerKilometer;
                } else if (kilometersPerMonth > 10000 && kilometersPerMonth <= 20000) {
                    pricePerKilometer = kilometersPerMonth * 1.45;
                    sum = pricePerKilometer;
                }
                break;
        }


        double salary = sum * 4;
        salary = salary * 0.9;

        System.out.printf("%.2f", salary);
    }
}
