package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        boolean areBalanced = false;

        ArrayDeque <Character> brackets = new ArrayDeque<>();

        for (int index = 0; index < input.length(); index++) {
            char currentBracket = input.charAt(index);

            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                brackets.push(currentBracket);
            } else if (currentBracket == ')' || currentBracket == '}' || currentBracket == ']') {

                if (brackets.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char lastOpenBracket = brackets.pop();

                if (lastOpenBracket == '(' && currentBracket == ')') {
                    areBalanced = true;
                } else if (lastOpenBracket == '[' && currentBracket == ']') {
                    areBalanced = true;
                } else if (lastOpenBracket == '{' && currentBracket == '}') {
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }


            }
        }

        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

