package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int[] numbers = Arrays.stream(input.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        //add
        Function<int[], int[]> add = arr -> Arrays.stream(arr).map(number -> number += 1).toArray();

        //multiply
        Function<int[], int[]> multiply = arr -> Arrays.stream(arr).map(number -> number * 2).toArray();

        //subtract
        Function<int[], int[]> subtract = arr -> Arrays.stream(arr).map(number -> number -= 1).toArray();

        // print
        Consumer<int[]> print = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));


        String command = scanner.nextLine();

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;

                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;

                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;

                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }


            command = scanner.nextLine();
        }


    }
}
