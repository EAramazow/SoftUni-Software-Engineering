package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        // компаратора работи с 0, 1 и -1
        // 0 -> не разменя елементите
        // -1 -> не разменя елементите
        // 1 -> разменя елементите

        Comparator<Integer> comparator = ((first, second) -> {
            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            } else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            } else {
                return first.compareTo(second);
            }
        });

        numbers.stream().sorted(comparator).forEach(num -> System.out.print(num + " "));
    }
}
