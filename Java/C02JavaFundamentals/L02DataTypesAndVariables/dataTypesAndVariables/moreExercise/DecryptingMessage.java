package dataTypesAndVariables.moreExercise;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int nChars = Integer.parseInt(scanner.nextLine());

        int currentASCI = 0;

        for (int i = 0; i < nChars; i++) {
            char currentSymbol = scanner.nextLine().charAt(0);
            currentASCI = currentSymbol + key;
            String character = Character.toString((char) currentASCI);
            System.out.print(character);

        }
    }
}
