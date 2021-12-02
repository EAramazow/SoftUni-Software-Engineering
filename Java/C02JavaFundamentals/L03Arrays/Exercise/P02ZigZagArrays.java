package arrays.Exercise;

import java.util.Scanner;

public class P02ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int row = 0; row < n; row++) {
            String input = scanner.nextLine();
            int firstNum = Integer.parseInt(input.split(" ")[0]);
            int secondNum = Integer.parseInt(input.split(" ")[1]);

            if ((row + 1) % 2 == 0) {
                firstArray[row] = secondNum;
                secondArray[row] = firstNum;
            } else {
                firstArray[row] = firstNum;
                secondArray[row] = secondNum;
            }
        }
        for (int number : firstArray) {
            System.out.println(number + " ");

        }
        System.out.println();
        for (int number : secondArray) {
            System.out.println(number + " ");
        }


    }

}
