package lists.Exercise;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> specialAndBomb = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int specialNumber = specialAndBomb.get(0);
        int power = specialAndBomb.get(1);
        int minimum = Integer.MIN_VALUE;


        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);

            if (currentNumber == specialNumber) {
                for (int j = 0; j < power; j++) {
                    if (i - 1 - j >= 0) numbers.set(i - 1 - j, minimum);
                    if (i + 1 + j < numbers.size()) numbers.set(i + 1 + j, minimum);
                }
                numbers.set(i, minimum);
            }
        }

        while (numbers.contains(minimum)) {
            numbers.remove(Integer.valueOf(minimum));
        }

        System.out.println(numbers.stream().mapToInt(Integer::intValue).sum());
    }
}





