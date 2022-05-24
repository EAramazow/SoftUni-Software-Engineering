package arrays.Lab;

import java.util.Scanner;

public class P04ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        for (int i = 0; i < input.length / 2; i++) {
            String temporary = input[i];
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temporary;
        }
        System.out.println(String.join(" ", input));



        }
    }

