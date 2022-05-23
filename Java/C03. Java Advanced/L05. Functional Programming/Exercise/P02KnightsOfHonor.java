package FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Consumer;

public class P02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().trim().split("\\s+");


        Consumer<String[]> printNames = array -> {
            for (String name : array) {
                System.out.println("Sir " + name);
            }
        };

        printNames.accept(input);

    }
}
