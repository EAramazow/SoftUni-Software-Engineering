package textProcessing.Lab;

import java.util.Scanner;

public class P05DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        StringBuilder symbols = new StringBuilder();


        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                digits.append(currentSymbol);
            } else if (Character.isAlphabetic(currentSymbol)) {
                letters.append(currentSymbol);
            } else {
                symbols.append(currentSymbol);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(symbols);
    }
}
