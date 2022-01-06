package textProcessing.Lab;

import java.util.Scanner;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsToReplace = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String words : wordsToReplace) {
            String wordOfStars = replaceToStars(words);
            text = text.replace(words, wordOfStars);
        }
        System.out.println(text);
    }

    private static String replaceToStars(String wordsToReplace) {
        String replace = "";

        for (int i = 0; i < wordsToReplace.length(); i++) {
            replace += "*";
        }
        return replace;
    }
}
