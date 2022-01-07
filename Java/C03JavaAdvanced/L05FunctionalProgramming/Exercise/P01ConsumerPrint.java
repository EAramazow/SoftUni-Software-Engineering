package FunctionalProgramming.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
            String namesInput = input[i];
            Consumer<String> print = names -> System.out.println(names);
            print.accept(namesInput);

        }

    }
}
