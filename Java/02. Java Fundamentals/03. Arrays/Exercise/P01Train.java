package arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }
        for (int countPeople : numbers) {
            sum += countPeople;
            System.out.print(countPeople + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
