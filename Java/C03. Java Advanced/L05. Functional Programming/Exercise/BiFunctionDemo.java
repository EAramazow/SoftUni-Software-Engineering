package FunctionalProgramming.Exercise;

import java.util.function.BiFunction;

public class BiFunctionDemo {
    public static void main(String[] args) {

        int a = 5;
        double b = 3.45;


        BiFunction<Integer, Double, Double> sum = (num1, num2) -> num1 + num2;
        System.out.printf("%.2f", sum.apply(a, b));


        // BiFunction<приема1, приема2, връща> -> apply
    }
}
