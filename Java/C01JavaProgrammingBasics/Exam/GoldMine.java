package Exam24April2021;

import java.util.Scanner;

public class GoldMine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int locationsNumbers = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= locationsNumbers; i++) {
            double expectedYield = Double.parseDouble(scanner.nextLine());
            int daysNum = Integer.parseInt(scanner.nextLine());


            double sumGold = 0;

            for (int j = 1; j <= daysNum; j++) {
                double yieldGold = Double.parseDouble(scanner.nextLine());

                sumGold += yieldGold;


            }

            double avgYield = sumGold / daysNum;

            if (avgYield >= expectedYield) {
                System.out.printf("Good job! Average gold per day: %.2f.\n", avgYield);
            } else if (expectedYield > avgYield) {
                System.out.printf("You need %.2f gold.", expectedYield - avgYield);
            }
        }

    }
}


// judge - 70/100

// грешката е, че липсва \n на 32 ред