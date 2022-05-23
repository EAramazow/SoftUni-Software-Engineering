package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().trim().split("\\s+");

        Predicate<String> predicate = str -> Character.isUpperCase(str.charAt(0));

        List<String> upperCase = Arrays.stream(input)
                .filter(predicate)
                .collect(Collectors.toList());

        System.out.println(upperCase.size());
        System.out.println(String.join(System.lineSeparator(), upperCase));
    }
}
