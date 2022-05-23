package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque <String> stack = new ArrayDeque<>();

        String input = scanner.nextLine();

        String currentURL = null;

        while (!input.equals("Home")) {

            boolean hasNoPreviousURLs = false;

            if (input.equals("back")) {
                if (!stack.isEmpty()) {
                    currentURL = stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    hasNoPreviousURLs = true;
                }

            } else {
                if (currentURL != null) {
                    stack.push(currentURL);
                }

            currentURL = input;

            }

            if (!hasNoPreviousURLs) {
                System.out.println(currentURL);
            }

            input = scanner.nextLine();
        }
    }
}
