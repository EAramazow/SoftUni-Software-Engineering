package textProcessing.Exercise;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder builder = new StringBuilder();

        for (char symbols : input.toCharArray()) {
            char currentSymbol = (char) (symbols + 3);
            builder.append(currentSymbol);
        }
        System.out.println(builder);
    }
}


