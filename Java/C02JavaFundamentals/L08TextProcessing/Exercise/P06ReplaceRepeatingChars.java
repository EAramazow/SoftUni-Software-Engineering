package textProcessing.Exercise;

import java.util.Scanner;

public class P06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();
        StringBuilder builder = new StringBuilder();

        char firstLetter = inputText.charAt(0);
        builder.append(firstLetter);

        for (int i = 1; i < inputText.length(); i++) {
            char currentLetter = inputText.charAt(i);
            char lastLetter = builder.charAt(builder.length() - 1);
            if (currentLetter != lastLetter) {
                builder.append(currentLetter);
            }
        }

        System.out.println(builder);
    }
}
