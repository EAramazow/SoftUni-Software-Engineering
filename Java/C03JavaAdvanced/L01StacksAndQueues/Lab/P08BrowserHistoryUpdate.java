package StacksAndQueues.Lab;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> backStack = new ArrayDeque<>();
        ArrayDeque<String> forwardQueue = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (backStack.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forwardQueue.addFirst(backStack.peek());
                    backStack.pop();
                    System.out.println(backStack.peek());
                }


            } else if (input.equals("forward")) {
                if (forwardQueue.size() < 1) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardQueue.peek());
                    backStack.push(forwardQueue.poll());
                }


            } else {
                backStack.push(input);
                System.out.println(input);
                forwardQueue.clear();

            }

            input = scanner.nextLine();
        }


    }
}