package ConditionalStatements.Lab;

import java.util.Scanner;

public class P07ToyShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double priceTour = Double.parseDouble(scanner.nextLine());
        int puzzle = Integer.parseInt(scanner.nextLine());
        int talkingDoll = Integer.parseInt(scanner.nextLine());
        int teddyBear = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        double SUMPuzzle = puzzle * 2.60;
        double SUMTalkingDoll = talkingDoll * 3;
        double SUMTeddyBear = teddyBear * 4.10;
        double SUMMinions = minions * 8.20;
        double SUMTrucks = trucks * 2;

        double sum = SUMPuzzle + SUMTalkingDoll + SUMTeddyBear + SUMMinions + SUMTrucks;
        double numberToys = puzzle + talkingDoll + teddyBear + minions + trucks;

        if ((numberToys) >= 50) {
            double discount = sum * 0.25;

            sum -= discount;
        }

        double rentShop = sum * 0.10;
        sum -= rentShop;



        if (sum >= priceTour) {
            System.out.printf("Yes! %.2f lv left.", sum - priceTour);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", priceTour - sum);
        }
    }
}


