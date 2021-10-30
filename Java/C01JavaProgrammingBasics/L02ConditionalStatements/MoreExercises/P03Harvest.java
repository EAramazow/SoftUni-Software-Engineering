package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class P03Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int xVineyard = Integer.parseInt(scanner.nextLine());
        double yGrapes = Double.parseDouble(scanner.nextLine());
        int neededLiters = Integer.parseInt(scanner.nextLine());
        int numberWorkers = Integer.parseInt(scanner.nextLine());


        double allGrapes = xVineyard * yGrapes;
        double wine = (allGrapes * 0.4) / 2.5;
        double liters = Math.abs(wine - neededLiters);
        double literPerPerson = liters / numberWorkers;


        if (wine < neededLiters) {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(liters));


        } else if (wine >= neededLiters) {

            System.out.printf("Good harvest this year! Total wine: %.0f liters.\n%.0f liters left -> %.0f liters per person.", Math.floor(wine), Math.ceil(liters), Math.ceil(literPerPerson));


        }
    }
}
