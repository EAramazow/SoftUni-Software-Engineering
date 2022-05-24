package textProcessing.Lab;

import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String wordToRemove = scanner.nextLine();
        String input = scanner.nextLine();

        while (input.contains(wordToRemove)) {

            input = removeMethod(input, wordToRemove);
        }

        System.out.println(input);
    }

    private static String removeMethod(String text, String wordToRemove) {
        int startIndex = text.indexOf(wordToRemove);
        int endIndex = wordToRemove.length() + startIndex;
        String firstPart = text.substring(0, startIndex);
        String secondPart = text.substring(endIndex);
        return firstPart + secondPart;
    }

}

