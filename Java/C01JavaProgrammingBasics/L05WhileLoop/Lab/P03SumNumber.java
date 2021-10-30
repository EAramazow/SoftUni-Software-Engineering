package WhileLoop.Lab;

import java.util.Scanner;

public class P03SumNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int initialNum = Integer.parseInt(scanner.nextLine());


        int sum = 0;

        while (sum < initialNum) {
            int currentNum = Integer.parseInt(scanner.nextLine());

            sum += currentNum;

//            if (sum >= initialNum) {
//                break;
//            }

        }

        System.out.println(sum);
    }
}
