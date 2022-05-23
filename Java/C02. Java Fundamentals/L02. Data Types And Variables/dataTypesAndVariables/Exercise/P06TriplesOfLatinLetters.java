package dataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P06TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = 255;

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int liters = Integer.parseInt(scanner.nextLine());

            sum += liters;
            if (sum > capacity) {
                System.out.println("Insufficient capacity!");
                sum -= liters;
            }

        }
        System.out.println(sum);
    }
}
