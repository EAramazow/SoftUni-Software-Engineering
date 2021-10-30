package NestedLoops.Exercises;

import java.util.Scanner;

public class P02EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());

        for (int i = n1; i <= n2 ; i++) {
            int evenSum = 0;
            int oddSum = 0;
            int currentNum = i;

            for (int pos = 6; pos >= 1 ; pos--) {
                // Взимам последната цифра от числото
                int digit = currentNum % 10;

                // Премахвам последната цифра
                currentNum /= 10;
                if (pos % 2 == 0) {
                    evenSum += digit;
                } else {
                    oddSum += digit;
                }
            }

            // Проверка дали сумите на четни и нечетни позиции са равни
            if (evenSum == oddSum) {
                System.out.print(i + " ");
            }
        }
    }
}
