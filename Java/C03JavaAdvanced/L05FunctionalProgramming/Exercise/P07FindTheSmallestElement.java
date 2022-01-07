package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Consumer<List<Integer>> indexMinElement = list -> {
          int min = Collections.min(list);
            System.out.println(list.lastIndexOf(min));
        };

        indexMinElement.accept(numbers);

//        WITH FUNCTION

//        Function<List<Integer>, Integer> getMinIndex = list -> list.lastIndexOf(Collections.min(list));
//        System.out.println(getMinIndex.apply(numbers));



    }

}
