package methods.Lab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.toLowerCase().equals("string")) {
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            String maxString = getMax(first, second);
            System.out.println(maxString);
        } else if (input.toLowerCase().equals("char")) {
            char first = scanner.nextLine().charAt(0);
            char second = scanner.nextLine().charAt(0);
            char maxChar = getMax(first, second);
            System.out.println(maxChar);
        } else if (input.toLowerCase().equals("int")) {
            int firstNum = Integer.parseInt(scanner.nextLine());
            int secondNum = Integer.parseInt(scanner.nextLine());
            int maxInt = getMax(firstNum, secondNum);
            System.out.println(maxInt);
        }
    }


    private static int getMax(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber) {
            return firstNumber;
        }
        return secondNumber;
    }

    private static char getMax(char firstChar, char secondChar) {
        if (firstChar > secondChar) {
            return firstChar;
        }
        return secondChar;
    }

    private static String getMax(String firstString, String secondString) {
        if (firstString.compareTo(secondString) >= 0) {
            return firstString;
        }
        return secondString;
    }
}
