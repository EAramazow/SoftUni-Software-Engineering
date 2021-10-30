package ForLoop.Exercise;

import java.util.Scanner;

public class P05DivideWithoutRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number % 2 == 0) {
                p1++;
            }
            if (number % 3 == 0) {
                p2++;
            }
            if (number % 4 == 0) {
                p3++;
            }

        }

        System.out.printf("%.2f%%", p1 * 1.0 / n * 100);
        System.out.printf("\n%.2f%%", p2 * 1.0 / n * 100);
        System.out.printf("\n%.2f%%", p3 * 1.0 / n * 100);

    }
}
