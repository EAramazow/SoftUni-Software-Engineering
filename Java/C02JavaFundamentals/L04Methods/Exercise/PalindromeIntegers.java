package methods.Exercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("END")) {

            System.out.print(isPalindrome(command));


            command = scanner.nextLine();
        }
    }

    private static boolean isPalindrome(String number) {
        String reversedNumber = getReversedNumber(number);


        if (number.equals(reversedNumber)) {
            return true;
        } else {
            return false;
        }
    }

    private static String getReversedNumber(String number) {
        String reversed = "";

        for (int index = number.length() - 1; index >= 0; index--) {
            char currentSymbol = number.charAt(index);
            reversed += currentSymbol;
        }
        return reversed;
    }
}
