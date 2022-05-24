package StacksAndQueues.Lab;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MainPriorityQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // PriorityQueue
        // if is numbers - it will be ordered 1, 2, 3, 4, 5 .....
        // if is letters - it will be alphabetically a, b, c, d ....

        PriorityQueue <Integer> numbers = new PriorityQueue<>();

        numbers.offer(13);
        numbers.offer(6);
        numbers.offer(69);
        numbers.offer(42);

        while (!numbers.isEmpty()) {
            System.out.println(numbers.poll());
        }

    }
}
