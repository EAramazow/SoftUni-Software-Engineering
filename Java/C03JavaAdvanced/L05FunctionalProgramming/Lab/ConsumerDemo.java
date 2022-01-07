package FunctionalProgramming.Lab;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        //Consumer<T> is a void interface :


        Consumer<String> print = message -> System.out.println(message);
        print.accept("Emil");
    }
}
