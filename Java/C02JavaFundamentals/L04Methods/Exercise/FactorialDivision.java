package methods.Exercise;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        double allSum = numbersFactorials(firstNum, secondNum);
        System.out.printf("%.2f", allSum);
    }

    private static double numbersFactorials(double firstNum, double secondNum) {
        double firstFactorial = 1;
        double secondFactorial = 1;
        double allSum = 0;

        for (int i = 1; i <= firstNum; i++) {
            firstFactorial = firstFactorial * i;
        }

        for (int i = 1; i <= secondNum; i++) {
            secondFactorial *= i;
        }
        allSum = firstFactorial / secondFactorial;

        return allSum;
    }


}
