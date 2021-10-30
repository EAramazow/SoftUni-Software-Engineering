package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        double numberOfPeople = Double.parseDouble(scanner.nextLine());


        double vipTicket = 499.99;
        double normalTicket = 249.99;

        double transport = 0;
        double sumAfterTransport = 0;
        double ticketsMoney = 0;


        if (numberOfPeople >= 1 && numberOfPeople <= 4) {
            transport = budget * 0.75;
        } else if (numberOfPeople >= 5 && numberOfPeople <= 9) {
            transport = budget * 0.60;

        } else if (numberOfPeople >= 10 && numberOfPeople <= 24) {
            transport = budget * 0.50;

        } else if (numberOfPeople >= 25 && numberOfPeople <= 49) {
            transport = budget * 0.40;
        } else {
            transport = budget * 0.25;
        }

        sumAfterTransport = budget - transport;

        switch (category) {
            case "Normal":
                ticketsMoney = numberOfPeople * normalTicket;
                break;

            case "VIP":
                ticketsMoney = numberOfPeople * vipTicket;
                break;
            default:
        }

        double allMoney = sumAfterTransport - ticketsMoney;
        if (allMoney < 0) {
            System.out.printf("Not enough money! You need %.2f leva.", Math.abs(allMoney));

        } else {
            System.out.printf("Yes! You have %.2f leva left.", allMoney);

        }


    }
}
