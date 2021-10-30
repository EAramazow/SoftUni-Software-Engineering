package ForLoop.Exercise;

import java.util.Scanner;

public class P03OddEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double oddSum = 0;
        double evenSum = 0;
        double oddMinNum = Double.POSITIVE_INFINITY;
        double evenMinNum = Double.POSITIVE_INFINITY;

        double oddMaxNum = Double.NEGATIVE_INFINITY;
        double evenMaxNum = Double.NEGATIVE_INFINITY;


        for (int i = 1; i <= n; i++) {
            double number = Double.parseDouble(scanner.nextLine());

            // намиране четни позиции
            if (i % 2 == 0) {
                evenSum += number;
                // проверка за минимално число
                if (number < evenMinNum) {
                    evenMinNum = number;
                }

                // проверка за максимално число

                if (number > evenMaxNum) {
                    evenMaxNum = number;
                }

            } else { // нечетни позиции
                oddSum += number;

                if (number < oddMinNum) {
                    oddMinNum = number;
                }

                // проверка за минимално число
                if (number > oddMaxNum) {
                    oddMaxNum = number;
                }
            }


        }

        System.out.printf("OddSum = %.2f,%n", oddSum);
        if (oddSum == 0) {
            System.out.printf("OddMin=No,%nOddMax=No");
        } else {
            System.out.printf("OddMin=%.2f,%nOddMax=%.2f,%n", oddMinNum, oddMaxNum);

        }


        System.out.printf("EvenSum = %.2f,%n", evenSum);
        if (evenSum == 0) {
            System.out.printf("EvenMin=No,%nEvenMax=No");

        } else {

            System.out.printf("EvenMin=%.2f,%nEvenMax=%.2f", evenMinNum, evenMaxNum);

        }
    }
}
