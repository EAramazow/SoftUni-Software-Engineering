package arrays.Exercise;

import java.util.Scanner;

public class P04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] number = input.split(" ");
        int countRotations = Integer.parseInt(scanner.nextLine());

        for (int rotation = 1; rotation <= countRotations; rotation++) {
            String firstElement = number[0];

            for (int index = 0; index < number.length - 1; index++) {
                number[index] = number[index + 1];
            }

            number[number.length - 1] = firstElement;
        }
        System.out.println(String.join(" ", number));
    }
}
