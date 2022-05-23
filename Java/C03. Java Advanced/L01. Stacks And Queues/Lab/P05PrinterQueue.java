package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // FIFO - FIRST IN FIRST OUT

        String input = scanner.nextLine();

        ArrayDeque<String> queue = new ArrayDeque<>();


        while (!input.equals("print")) {

            if (input.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.pop());
                }
            } else {
                queue.offer(input);
            }


            input = scanner.nextLine();
        }
        for (String strings : queue) {
            System.out.println(strings);
        }
    }

}
