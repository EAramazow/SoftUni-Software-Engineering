package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P01SortEvenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> evenNumber = numbers.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());

        //ако се дублира, може да направим функция, която да използваме

        Function<Stream<Integer>, String> mutator = x -> x.map(String::valueOf)
                .collect(Collectors.joining(", "));

        String firstOutput = mutator.apply(evenNumber.stream());

        System.out.println(firstOutput);

        String secondOutput = mutator.apply(evenNumber.stream().sorted());

        System.out.println(secondOutput);



    }
}
