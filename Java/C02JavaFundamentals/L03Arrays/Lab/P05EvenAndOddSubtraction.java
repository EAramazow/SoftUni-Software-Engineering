package arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        // вариант 1 - превръщаме String в int

//        int [] numbers = new int[input.length];
//        for (int i = 0; i < input.length; i++) {
//            numbers[i] = Integer.parseInt(input[i]);
//        }
//
        // вариант 2 - превръщане на String в int - най-честият и най-лесният

        int [] numbersArray = Arrays.stream(input)
                .mapToInt(element -> Integer.parseInt(element))
                .toArray();

        int evenSum = 0;
        int oddSum = 0;

        for(int number : numbersArray) {
            if (number % 2 == 0) {
                evenSum += number;
            } else {
                oddSum += number;
            }
        }

        System.out.println(evenSum - oddSum);
    }
}
