package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P03NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String kindOfFlowers = scanner.nextLine();
        int quantityFlowers = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());



        double sum = 0;
        double finalSum = 0;


        switch (kindOfFlowers) {

            case "Roses":
                sum = quantityFlowers * 5.00;
                if (quantityFlowers > 80) {
                    sum = sum * 0.9;
                }
                break;

            case "Dahlias":
                sum = quantityFlowers * 3.80;
                if (quantityFlowers > 90) {
                    sum = sum * 0.85;
                }
                break;

            case "Tulips":
                sum = quantityFlowers * 2.80;
                if (quantityFlowers > 80) {
                    sum = sum * 0.85;
                }
                break;

            case "Narcissus":
                sum = quantityFlowers * 3.00;
                if (quantityFlowers < 120) {
                    sum = sum * 1.15;
                }
                break;

            case "Gladiolus":
                sum = quantityFlowers * 2.50;
                if (quantityFlowers < 80) {
                    sum = sum * 1.20;
                }
                break;


        }
        if (budget >= sum) {
            finalSum = budget - sum;
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", quantityFlowers, kindOfFlowers, finalSum);

        } else {
            finalSum = sum - budget;
            System.out.printf("Not enough money, you need %.2f leva more.", finalSum);

        }


    }
}
