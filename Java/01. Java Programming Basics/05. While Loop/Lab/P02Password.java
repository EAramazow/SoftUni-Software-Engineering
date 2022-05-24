package WhileLoop.Lab;

import java.util.Scanner;

public class P02Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userName = scanner.nextLine();
        String initialPass = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals(initialPass)) {

            input = scanner.nextLine();
        }

        System.out.printf("Welcome %s", userName);
    }
}
