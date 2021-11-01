package basicSyntaxConditionalStatementsLoops.Lab;

import java.util.Scanner;

public class MultiplicationTable1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = n; i <= n ; i++) {
            for (int j = 1; j <= 10 ; j++) {
                int sum = n * j;

                System.out.printf("%d X %d = %d\n", i, j, sum);
            }
        }
    }
}

