package midExam100721;

import java.util.Scanner;

public class ProblemOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantityFoodKG = Double.parseDouble(scanner.nextLine()) * 1000;
        double quantityHayKG = Double.parseDouble(scanner.nextLine()) * 1000;
        double quantityCoverKG = Double.parseDouble(scanner.nextLine()) * 1000;
        double guineaWeight = Double.parseDouble(scanner.nextLine()) * 1000;

        double everyDayFood = 300;
        boolean isOver = false;

        for (int i = 1; i <= 30; i++) {
            quantityFoodKG -= everyDayFood;

            if (i % 2 == 0) {
                double hay = quantityFoodKG * 0.05;
                quantityHayKG -= hay;

            }
            if (i % 3 == 0) {
                double cover = guineaWeight * 1 / 3;
                quantityCoverKG -= cover;
            }

            if (quantityFoodKG <= 0 || quantityCoverKG <= 0 || quantityHayKG <= 0) {
                isOver = true;
                System.out.println("Merry must go to the pet store!");
                break;
            }
        }


        if (!isOver) {

            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                    quantityFoodKG / 1000, quantityHayKG / 1000, quantityCoverKG / 1000);
        }

    }
}
