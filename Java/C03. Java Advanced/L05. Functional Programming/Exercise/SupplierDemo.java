package FunctionalProgramming.Exercise;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {

        Supplier<Integer> date = () -> 13;
        System.out.println(date.get());

        // Supplier<Връща> -> get

    }
}
