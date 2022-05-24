package basicSyntaxConditionalStatementsLoops.moreExercises;

import java.util.Scanner;

public class P04ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String reversed = "";

        for (int i = input.length() - 1; i >= 0 ; i--) {
            char symbols = input.charAt(i);
            reversed += symbols;
        }
        System.out.println(reversed);
    }
}
