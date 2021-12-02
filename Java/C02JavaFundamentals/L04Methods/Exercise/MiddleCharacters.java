package methods.Exercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        printMiddleCharacter(text);


    }

    private static void printMiddleCharacter(String text) {
        if (text.length() % 2 != 0) {
            int indexMiddleCharacter = text.length() / 2;
            System.out.println(text.charAt(indexMiddleCharacter));
        } else {
            int indexFirstMiddleCharacter = text.length() / 2 - 1;
            int indexSecondMiddleCharacter = text.length() / 2;
            System.out.printf("%c%c", text.charAt(indexFirstMiddleCharacter), text.charAt(indexSecondMiddleCharacter));
        }
    }
}
