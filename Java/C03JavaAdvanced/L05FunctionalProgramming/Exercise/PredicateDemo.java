package FunctionalProgramming.Exercise;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {


        Predicate<String> isEquals = word -> word.equals("Test");

        System.out.println(isEquals.test("Emil"));

        // Predicate return true or false -> test
    }
}