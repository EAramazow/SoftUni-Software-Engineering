package WhileLoop.MoreExercises;

import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ЧУЖДО РЕШЕНИЕ

        String word = "";
        String letter = "";

        boolean o = false;
        boolean c = false;
        boolean n = false;

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            char valid = input.charAt(0);
            if ((valid >= 'a' && valid <= 'z') || (valid >= 'A' && valid <= 'Z')) {
                switch (input) {
                    case "o":
                        if (o) {
                            word += input;
                        }
                        o = true;
                        break;
                    case "c":
                        if (c) {
                            word += input;
                        }
                        c = true;
                        break;
                    case "n":
                        if (n) {
                            word += input;
                        }
                        n = true;
                        break;
                    default:
                        word += input;
                        break;
                }

                if (o && c && n) {
                    System.out.print(word + " ");
                    o = false;
                    c = false;
                    n = false;

                    word = "";
                }
            }
            input = scanner.nextLine();
        }
    }
}




