package SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        Set<String> parkingLot = new LinkedHashSet<>();


        while (!input.equals("END")) {

            String direction = input.trim().split(", ")[0];
            String carNumber = input.trim().split(", ")[1];


            switch (direction) {
                case "IN":
                    parkingLot.add(carNumber);
                    break;

                case "OUT":
                    parkingLot.remove(carNumber);
                    break;
                default:
            }

            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String carNumbers : parkingLot) {
                System.out.println(carNumbers);
            }
        }
    }
}
