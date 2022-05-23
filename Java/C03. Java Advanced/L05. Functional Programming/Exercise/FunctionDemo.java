package FunctionalProgramming.Exercise;

import java.util.Scanner;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 5;
        Function<Integer, Integer> function = e -> e + e;
        System.out.println(function.apply(n));



        //Function<Приема, Връща> -> apply
    }
}
