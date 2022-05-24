package L08ExceptionsAndErrorHandling;

import java.util.Scanner;

public class P01SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            double number = Double.parseDouble(input);
            double mathsqrt = isValidNumber(number);
            System.out.println(mathsqrt);
        } catch (IllegalArgumentException e) {
            System.out.println("Number " + input + " is negative!");
        } finally {

            System.out.println("Good bye");
        }
    }

    private static double isValidNumber(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Invalid number!");
        }
        return Math.sqrt(number);
    }
}
