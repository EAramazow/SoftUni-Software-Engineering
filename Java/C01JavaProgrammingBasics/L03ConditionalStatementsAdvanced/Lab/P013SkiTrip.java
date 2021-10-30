package ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class P013SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysStay = Integer.parseInt(scanner.nextLine());
        String kindOfRoom = scanner.nextLine();
        String rating = scanner.nextLine();

        int nights = 0;
        double sumRoom = 0;
        double onePersonRoom = 18;
        double apartment = 25;
        double presidentApartment = 35;
        double discount = 0;

        if (daysStay > 1) {
            nights = daysStay - 1;

        }

        if (kindOfRoom.equals("room for one person")) {
            sumRoom = nights * onePersonRoom;
        } else if (kindOfRoom.equals("apartment")) {

            if (nights < 10) {
                sumRoom = (nights * apartment) * 0.7;

            } else if (nights >= 10 && nights <= 15) {
                sumRoom = (nights * apartment) * 0.65;
            } else if (nights > 15) {
                sumRoom = (nights * apartment) * 0.50;
            }

        } else if (kindOfRoom.equals("president apartment")) {
            if (nights < 10 ) {
                sumRoom = (nights * presidentApartment) * 0.9;
            } else if (nights >= 10 && nights <= 15) {
                sumRoom = (nights * presidentApartment) * 0.85;
            } else if (nights > 15) {
                sumRoom = (nights * presidentApartment) * 0.8;
            }
        }

        if (rating.equals("positive")) {
            discount = sumRoom + (sumRoom * 0.25);
            System.out.printf("%.2f", discount);
        } else if (rating.equals("negative")) {
            discount = sumRoom - (sumRoom * 0.10);
            System.out.printf("%.2f", discount);
        }

    }
}
