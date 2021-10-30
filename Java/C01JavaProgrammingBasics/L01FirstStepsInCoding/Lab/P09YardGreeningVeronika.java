package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class P09YardGreeningVeronika {

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        double squareM = Double.parseDouble(scanner.nextLine());

        double price = squareM * 7.61;
        double discount = price * 0.18;

        double priceWithDiscount = price - discount;

        System.out.printf("The final price is: %f lv.%n", priceWithDiscount);
        System.out.printf("The discount is: %f lv.%n", discount);



    }
}
