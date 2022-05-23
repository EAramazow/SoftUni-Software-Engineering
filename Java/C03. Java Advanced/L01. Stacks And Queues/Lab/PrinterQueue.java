package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String task = scanner.nextLine();

        while (!task.equals("print")) {

            if (task.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String canceledTask = queue.poll();
                    System.out.println("Canceled " + canceledTask);
                }
            } else {
                queue.offer(task);

            }

            task = scanner.nextLine();
        }
            // first way to print
            //        for (String tasks : queue) {
            //            System.out.println(tasks);
            //        }

        // second way to print

       // System.out.println(queue.stream().collect(Collectors.joining(System.lineSeparator())));

        // third way to print

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
