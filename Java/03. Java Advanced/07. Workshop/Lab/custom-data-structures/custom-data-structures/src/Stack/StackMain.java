package Stack;

import java.sql.SQLOutput;

public class StackMain {
    public static void main(String[] args) {

        Stack stack = new Stack();

        System.out.println("Elements in Stack with push and peek methods: ");
        stack.push(13);
        System.out.println(stack.peek());
        stack.push(42);
        System.out.println(stack.peek());
        stack.push(55);
        System.out.println(stack.peek());


        System.out.println("Elements in Stack with forEach method: ");
        stack.forEach(System.out::println);


        System.out.println("Elements in Stack with pop method: ");
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
        
    }
}
