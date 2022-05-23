package methods.Exercise;

import java.util.Scanner;

public class VowelsCounts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();

        printCountVowels(text);
    }

    private static void printCountVowels(String text) {
        int count = 0;
        for (int index = 0; index <= text.length() - 1 ; index++) {
            char currentSymbol = text.charAt(index);

            switch (currentSymbol) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
            }
            
        }
        System.out.println(count);
    }
}
