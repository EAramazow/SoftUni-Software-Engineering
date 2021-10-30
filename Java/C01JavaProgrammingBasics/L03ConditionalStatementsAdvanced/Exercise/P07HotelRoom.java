package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P07HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());

        double studio = 0;
        double apartment = 0;

        double totalStudio = 0;
        double totalApartment = 0;

        switch (month) {
            case "May":
            case "October":
                studio = 50;
                apartment = 65;

                if (nights > 7 && nights <= 14) {
                    totalStudio = studio * nights * 0.95;
                    totalApartment = apartment * nights;

                } else if (nights > 14) {
                    totalStudio = studio * nights * 0.70;
                    totalApartment = apartment * nights * 0.90;
                } else {

                    totalStudio = studio * nights;
                    totalApartment = apartment * nights;
                }
                break;

            case "June":
            case "September":

                studio = 75.20;
                apartment = 68.70;

                if (nights <= 14) {
                    totalStudio = studio * nights;
                    totalApartment = apartment * nights;

                } else if (nights > 14) {
                    totalStudio = studio * nights * 0.80;
                    totalApartment = apartment * nights * 0.90;
                }
                break;

            case "July":
            case "August":

                studio = 76;
                apartment = 77;

                if (nights > 14) {
                    totalStudio = studio * nights;
                    totalApartment = apartment * nights * 0.90;
                } else if (nights <= 14) {
                    totalStudio = studio * nights;
                    totalApartment = apartment * nights;

                }
                break;
            default:
        }

        System.out.printf("Apartment: %.2f lv.", totalApartment);
        System.out.printf("\nStudio: %.2f lv.", totalStudio);

    }
}