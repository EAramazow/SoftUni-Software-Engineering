package dataTypesAndVariables.Exercise;

import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int character1 = 0; character1 < n; character1++) {
            for (int character2 = 0; character2 < n; character2++) {
                for (int character3 = 0; character3 < n; character3++) {

                    char firstChar = (char) ('a' + character1);
                    char secondChar = (char) ('a' + character2);
                    char thirdChar = (char) ('a' + character3);

                    System.out.printf("%c%c%c\n", firstChar, secondChar, thirdChar);
                }

            }

        }

    }
}
