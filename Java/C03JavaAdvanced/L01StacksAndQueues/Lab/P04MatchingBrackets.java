package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // LIFO - LAST IN FIRST OUT


        ArrayDeque <Integer> stack = new ArrayDeque<>();
        String input = scanner.nextLine();


        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '(') {
                stack.push(i);
            } else if (currentChar == ')') {
                int startIndex = stack.pop();
                System.out.println(input.substring(startIndex, i + 1));
            }

        }
    }
}
