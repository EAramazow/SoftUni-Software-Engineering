package arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] number = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < number.length; i++) {
            boolean isTop = true;
            for (int j = i + 1; j < number.length; j++) {
                if (number[i] <= number[j]) {
                    isTop = false;
                    break;
                }
            }
            if (isTop) {
                System.out.print(number[i] + " ");
            }
        }


    }

}
