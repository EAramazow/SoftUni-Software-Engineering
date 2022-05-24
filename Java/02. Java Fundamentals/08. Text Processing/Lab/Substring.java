package textProcessing.Lab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wordToRemove = scanner.nextLine();
        String input = scanner.nextLine();

        while (input.contains(wordToRemove)) {

//            input = input.replace(wordToRemove, ""); - начин за заместване без метод

            input = removeOccurence(input, wordToRemove);
        }
        System.out.println(input);
    }

    private static String removeOccurence(String text, String wordToRemove) {

        int beginIndex = text.indexOf(wordToRemove);
        int endIndex = wordToRemove.length() + beginIndex;

        String firstPart = text.substring(0, beginIndex);
        String secondPart = text.substring(endIndex);
        return firstPart + secondPart;
    }
}
