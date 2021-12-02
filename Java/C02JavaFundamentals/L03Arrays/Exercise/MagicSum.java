package arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int givenNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {

                if (array[i] + array[j] == givenNumber) {
                    System.out.print(array[i] + " ");
                    System.out.print(array[j] + " ");
                    System.out.println();
                    break;
                }

            }

        }


    }
}
