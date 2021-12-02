package methods.Lab;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());


        if (command.equals("add")) {
            addOperation(firstNumber, secondNumber);
        } else if (command.equals("multiply")) {
            multiplyOperation(firstNumber, secondNumber);
        } else if (command.equals("subtract")) {
            subtractOperation(firstNumber, secondNumber);
        } else {
            divideOperation(firstNumber, secondNumber);
        }

    }

    private static void addOperation(int firstNumber, int secondNumber) {
        int result = firstNumber + secondNumber;
        System.out.println(result);

    }

    private static void subtractOperation(int firstNumber, int secondNumber) {
        int result = firstNumber - secondNumber;
        System.out.println(result);
    }

    private static void multiplyOperation(int firstNumber, int secondNumber) {
        int result = firstNumber * secondNumber;
        System.out.println(result);
    }

    private static void divideOperation(int firstNumber, int secondNumber) {
        int result = firstNumber / secondNumber;
        System.out.println(result);
    }
}
