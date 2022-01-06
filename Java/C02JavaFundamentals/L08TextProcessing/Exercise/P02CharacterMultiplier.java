package textProcessing.Exercise;

import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] words = input.split("\\s+");

        String firstString = words[0];
        String secondString = words[1];

        int sum = multipliedResult(firstString, secondString);
        System.out.println(sum);
    }

    private static int multipliedResult(String firstString, String secondString) {

        int totalSum = 0;

        for (int i = 0; i < Math.min(firstString.length(), secondString.length()); i++) {
            totalSum += firstString.charAt(i) * secondString.charAt(i);
        }

        if (firstString.length() > secondString.length()) {
            for (int i = secondString.length(); i < firstString.length(); i++) {
                totalSum += firstString.charAt(i);
            }
        } else {
            for (int i = firstString.length(); i < secondString.length(); i++) {
                totalSum += secondString.charAt(i);
            }
        }
        return totalSum;
    }
}
