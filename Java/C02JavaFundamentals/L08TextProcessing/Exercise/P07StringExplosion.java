package textProcessing.Exercise;

import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        int bomb = 0;

        for (int i = 0; i < input.length(); i++) {

            if (bomb > 0 && input.charAt(i) != '>') {
                input.deleteCharAt(i); // Remove char on this index
                bomb--; // One bomb is used
                i--; // after remove next char is moved 1 position, so return counter i to this char, decreasing i by 1
            } else if (input.charAt(i) == '>') {
                bomb += Integer.parseInt(String.valueOf(input.charAt(i + 1))); // takes the digit after '>' - bomb strength and add to bomb
            }
        }
        System.out.println(input);
    }
}