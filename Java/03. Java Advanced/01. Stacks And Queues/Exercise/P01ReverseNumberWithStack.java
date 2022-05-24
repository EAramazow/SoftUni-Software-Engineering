package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01ReverseNumberWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");

        for (String s : input) {
            numbersStack.push(Integer.parseInt(s));
        }

        for (Integer numbers : numbersStack) {
            System.out.print(numbers + " ");
        }


    }
}
