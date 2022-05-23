package methods.Exercise;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        printTopNumbers(number);

    }

    private static void printTopNumbers(int number) {
        for (int i = 1; i <= number; i++) {
            if (divisibleByEight(i) && oddDigit(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean divisibleByEight(int number) {
        int digitsSum = 0;

        while (number > 0) {
            digitsSum += number % 10;
            number = number / 10;

        }

        if (digitsSum % 8 == 0) {
            return true;
        } else {

            return false;
        }

    }

    private static boolean oddDigit(int number) {
        while (number > 0) {
            if ((number % 10) % 2 == 1) {
                return true;
            }
            number = number / 10;
        }
        return false;
    }
}


