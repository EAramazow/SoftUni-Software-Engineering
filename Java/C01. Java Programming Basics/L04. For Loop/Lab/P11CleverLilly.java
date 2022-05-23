package ForLoop.Lab;

import java.util.Scanner;

public class P11CleverLilly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double priceWashMachine = Double.parseDouble(scanner.nextLine());
        int priceToy = Integer.parseInt(scanner.nextLine());


        int countToys = 0;
        int countBrother = 0;
        double money = 0;
        double sumMoney = 0;


        for (int i = 1; i <= age; i++) {

            if (i % 2 != 0) {
                countToys++;
            } else {
                countBrother++;
                money = money + 10;
                sumMoney += money;
            }

        }

        int allToysMoney = countToys * priceToy;
        double allMoney = allToysMoney + sumMoney - countBrother;

        double difference = Math.abs(allMoney - priceWashMachine);

        if (allMoney >= priceWashMachine) {
            System.out.printf("Yes! %.2f", difference);
        } else {
            System.out.printf("No! %.2f", difference);
        }
    }
}
