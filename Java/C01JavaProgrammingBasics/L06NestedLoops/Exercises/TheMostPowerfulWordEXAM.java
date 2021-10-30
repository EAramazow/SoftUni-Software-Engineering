package NestedLoops.Exercises;

import java.util.Scanner;

public class TheMostPowerfulWordEXAM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String word = scanner.nextLine();
        double maxPower = Double.NEGATIVE_INFINITY;
        String maxWord = "";

        while (!word.equals("End of words")) {
            int asciiSum = 0;
            double result = 0;
            boolean isVowel = false;


            for (int i = 0; i < word.length(); i++) {
                char symbol = word.charAt(i);
                char firstSymbol = word.charAt(0);

                if (firstSymbol == 'a' || firstSymbol == 'A' ||
                        firstSymbol == 'e' || firstSymbol == 'E' ||
                        firstSymbol == 'i' || firstSymbol == 'I' ||
                        firstSymbol == 'o' || firstSymbol == 'O' ||
                        firstSymbol == 'u' || firstSymbol == 'U' ||
                        firstSymbol == 'y' || firstSymbol == 'Y') {
                    isVowel = true;

                }

                asciiSum += symbol;

            }
            if (isVowel) {
                result = asciiSum * word.length();

            } else {
                result = Math.floor(asciiSum / word.length());
            }

            if (result > maxPower) {
                maxPower = result;
                maxWord = word;

            }


            word = scanner.nextLine();
        }

        System.out.printf("The most powerful word is %s - %.0f", maxWord, maxPower);
    }
}
