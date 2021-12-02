package methods.Lab;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNumber = Integer.parseInt(scanner.nextLine());

        double result = calculations(firstNumber, operator, secondNumber);
        System.out.printf("%.0f", Math.ceil(result));

    }

    private static double calculations(int firstNumber, String operator, int secondNumber) {
        double result = 0;

        if (operator.equals("+")) {
            result = firstNumber + secondNumber;
        } else if (operator.equals("-")) {
            result = firstNumber - secondNumber;
        } else if (operator.equals("*")) {
            result = firstNumber * secondNumber;
        } else if (operator.equals("/")) {
            result = firstNumber * 1.0 / secondNumber;
        }
        return result;
    }
}
