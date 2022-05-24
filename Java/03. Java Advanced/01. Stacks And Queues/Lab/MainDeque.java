package StacksAndQueues.Lab;

import java.util.ArrayDeque;

public class MainDeque {
    public static void main(String[] args) {

        // stacks functions :
        // .push - add elements at the top of the stack
        // .pop - remove the element from the top of the stack
        // .peek - see what we have at the top of the stack

        ArrayDeque<Integer> stack = new ArrayDeque<>();   // LIFO - Last in first out


        stack.push(13);
        stack.push(73);
        stack.push(69);

        //  int lastElement = stack.pop();
        // System.out.println(lastElement);

        // System.out.println(stack.peek());

        // обхождане на stack

        for (int num : stack) {
            System.out.println(num);
        }



    }
}
