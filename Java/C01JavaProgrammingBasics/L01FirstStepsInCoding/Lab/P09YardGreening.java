package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class P09YardGreening {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int realSquareMeters = Integer.parseInt(scanner.nextLine());

        double price = realSquareMeters * 7.61;

        double discountPrice = 0.18 * price;

        double sum = price - discountPrice;

        System.out.println("The final price is " + sum + " lv.");
        System.out.println("The discont is " + discountPrice + " lv.");


    }
}