package FunctionalProgramming.Exercise;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {


        String names = "Emil";

        Consumer<String> print = name -> System.out.println(name);
        print.accept(names);

        //Consumer<Приема> -> void -> accept
    }
}
