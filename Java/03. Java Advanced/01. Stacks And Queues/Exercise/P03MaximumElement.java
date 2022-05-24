package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            String commands = scanner.nextLine();

            if (commands.equals("2")) {
                stack.pop();
            } else if (commands.equals("3")) {
                if (!stack.isEmpty()) {
                    System.out.println(Collections.max(stack));
                }
            } else {
                int x = Integer.parseInt(commands.split("\\s+")[1]);
                stack.push(x);
            }

        }
    }
}
