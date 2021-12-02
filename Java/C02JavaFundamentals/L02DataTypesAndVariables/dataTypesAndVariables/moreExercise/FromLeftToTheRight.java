package dataTypesAndVariables.moreExercise;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int rotations = 0; rotations < input; rotations++) {
            long leftNum = Long.parseLong(scanner.next());
            long rightNum = Long.parseLong(scanner.next());
            int sum = 0;

            if (leftNum > rightNum) {
                long left = leftNum;
                while (left != 0) {
                    sum += Math.abs(left % 10);
                    left = Math.abs(left / 10);
                }
            } else {
                long right = rightNum;
                while (right != 0) {
                    sum += Math.abs(right % 10);
                    right = Math.abs(right / 10);
                }
            }

            System.out.println(Math.abs(sum));

        }
    }
}
