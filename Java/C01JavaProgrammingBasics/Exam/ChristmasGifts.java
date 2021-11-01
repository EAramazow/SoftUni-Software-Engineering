package Exam24April2021;

import java.util.Scanner;

public class ChristmasGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int under16Count = 0;
        int upper16Count = 0;
        int toysCount = 0;
        int sweatersCount = 0;
        double toysSum = 0;
        double sweatersSum = 0;

        while (!input.equals("Christmas")) {
            int age = Integer.parseInt(input);

            if (age <= 16) {
                under16Count++;
                toysCount++;
                toysSum = toysCount * 5;
            } else {
                upper16Count++;
                sweatersCount++;
                sweatersSum = sweatersCount * 15;
            }


            input = scanner.nextLine();
        }

        System.out.printf("Number of adults: %d", upper16Count);
        System.out.printf("\nNumber of kids: %d", under16Count);
        System.out.printf("\nMoney for toys: %.0f", toysSum);
        System.out.printf("\nMoney for sweaters: %.0f", sweatersSum);

    }
}
