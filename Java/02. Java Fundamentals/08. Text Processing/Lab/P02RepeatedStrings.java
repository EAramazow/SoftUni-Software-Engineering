package textProcessing.Lab;

import java.util.Scanner;

public class P02RepeatedStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        StringBuilder result = new StringBuilder();

        for (String words : input) {

            for (int i = 0; i < words.length(); i++) {
                result.append(words);
            }
        }

        System.out.println(result);
    }
}
