package L01WorkingWithAbstraction.Lab.P04HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().trim().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2]);
        Discount discount = Discount.parseDiscount(input[3]);

        PriceCalculator calculator = new PriceCalculator(pricePerDay, numberOfDays, season, discount);

        System.out.printf("%.2f\n", calculator.calculatedPrice());

    }
}
