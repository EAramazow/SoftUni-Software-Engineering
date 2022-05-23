package dataTypesAndVariables.Lab;

import java.util.Scanner;

public class P12RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());
        boolean isSpecialNumber = false;



        for (int currentNumber = 1; currentNumber <= number; currentNumber++) {
            int digit = currentNumber;
            int sum = 0;

            while (digit > 0) {
                int currentDigit = digit % 10;
                sum += currentDigit;
                digit = digit / 10;
            }

                if (sum == 5 || sum == 7 || sum == 11) {
                    isSpecialNumber = true;
                    System.out.printf("%d -> True\n", currentNumber);
                } else {
                    System.out.printf("%d -> False\n", currentNumber);

                }

        }
    }
}