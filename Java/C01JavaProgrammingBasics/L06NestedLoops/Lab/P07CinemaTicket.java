package NestedLoops.Lab;

import java.util.Scanner;

public class P07CinemaTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int counterTotalTickets = 0;
        int studentCounter = 0;
        int standardCounter = 0;
        int kidsCounter = 0;


        while (!input.equals("Finish")) {
            String movieName = input;
            int freeSeats = Integer.parseInt(scanner.nextLine());


            int counterTicket = 0;
            String command = scanner.nextLine();
            while (!command.equals("End")) {
                String typeTicket = command;
                counterTicket++;

                switch (typeTicket) {
                    case "student":
                        studentCounter++;
                        break;
                    case "standard":
                        standardCounter++;
                        break;
                    case "kid":
                        kidsCounter++;
                        break;
                }

                if (counterTicket == freeSeats) {
                    break;
                }


                command = scanner.nextLine();
            }
            counterTotalTickets += counterTicket;

            System.out.printf("%s - %.2f%% full.\n", movieName, counterTicket * 1.0 / freeSeats * 100);

            input = scanner.nextLine();
        }
        System.out.println("Total tickets: " + counterTotalTickets);
        System.out.printf("%.2f%% student tickets.\n", studentCounter * 1.0 / counterTotalTickets * 100);
        System.out.printf("%.2f%% standard tickets.\n", standardCounter * 1.0 / counterTotalTickets * 100);
        System.out.printf("%.2f%% kids tickets.\n", kidsCounter * 1.0 / counterTotalTickets * 100);
    }
}
