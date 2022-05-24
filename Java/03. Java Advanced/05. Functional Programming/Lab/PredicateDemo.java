package FunctionalProgramming.Lab;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Predicate evaluate a condition : (подобно на булев израз)

        Predicate<Integer> isEven = number -> number % 2 == 0;

        System.out.println(isEven.test(3));        // true or false

    }
}
