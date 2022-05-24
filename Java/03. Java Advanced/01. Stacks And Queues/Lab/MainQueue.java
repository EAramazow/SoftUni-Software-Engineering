package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MainQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // the difference between deque and queue is only in functions

        ArrayDeque<Integer> queue = new ArrayDeque<>();   // FIFO - first in first out

        // more info in presentation

        // queue functions :
        // queue.add(element); - throws exception if queue is full


        // queue.offer(element); - add
        //queue.poll(element) - remove
        //queue.peek(element) - peek

    }
}
