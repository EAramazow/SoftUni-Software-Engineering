package FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

//          FIRST WAY TO RESOLVE THE PROBLEM
//        Function<List<Integer>, Integer> getMinNumber = list -> Collections.min(list);
//        System.out.println(getMinNumber.apply(numbers));

        // SECOND WAY TO RESOLVE THE PROBLEM

        Consumer<List<Integer>> printMinNumber = list -> System.out.println(Collections.min(list));
        printMinNumber.accept(numbers);
    }
}
