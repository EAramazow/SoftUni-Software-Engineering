package WhileLoop.Lab;

import java.util.Scanner;

public class P042K1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int k = 1;

        while (k <= num) {

            System.out.println(k);

            k = k * 2 + 1;
        }
    }
}
