package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;


public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Function<String, Integer> lengthIntegers = string -> string.split(", ").length;

        Function<String, Integer> sumIntegers = string -> Arrays.stream(string.split(", "))
        .mapToInt(Integer::parseInt).sum();

        System.out.println("Count = " + lengthIntegers.apply(input));
        System.out.println("Sum = " + sumIntegers.apply(input));
    }

}
