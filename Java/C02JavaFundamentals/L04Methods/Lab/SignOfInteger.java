package methods.Lab;

import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        positiveNumber(n);
        negativeNumber(n);
        zeroNumber(n);
    }

    private static void positiveNumber(int number) {
        if (number > 0) {
            System.out.printf("The number %d is positive.", number);
        }
    }

    private static void negativeNumber(int number) {
        if (number < 0) {
            System.out.printf("The number %d is negative.", number);
        }
    }

    private static void zeroNumber(int number) {
        if (number == 0) {
            System.out.printf("The number %d is zero.", number);
        }


    }
}
