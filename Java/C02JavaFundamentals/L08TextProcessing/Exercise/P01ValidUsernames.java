package textProcessing.Exercise;

import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] words = input.split(", ");

        for (String word : words) {
            if (isValidUsername(word)) {
                System.out.println(word);
            }
        }
    }

    private static boolean isValidUsername(String word) {

        if (!(word.length() >= 3 && word.length() <= 16)) {
            return false;
        }

        for (char symbol : word.toCharArray()) {
            if (!(Character.isLetterOrDigit(symbol) || symbol == '-' || symbol == '_')) {
                return false;
            }
        }
        return true;
    }

}
