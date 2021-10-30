package ConditionalStatements.Lab;

import java.util.Scanner;

public class P02GreaterNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        if (num > num2) {
            System.out.println(num);
        } else {
            System.out.println(num2);
        }
    }
}
