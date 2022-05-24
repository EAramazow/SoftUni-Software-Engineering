package basicSyntaxConditionalStatementsLoops.Exercise;

import java.util.Scanner;

public class P04PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNumber = Integer.parseInt(scanner.nextLine());
        int stopNumber = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        for (int i = startNumber; i <= stopNumber; i++) {

            System.out.print(i + " ");
            sum += i;

        }
        System.out.println();
        System.out.printf("Sum: %d", sum);
    }
}
