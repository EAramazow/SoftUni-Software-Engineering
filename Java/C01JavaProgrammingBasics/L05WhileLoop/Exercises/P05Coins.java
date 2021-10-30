package WhileLoop.Exercises;

import java.util.Scanner;

public class P05Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double sum = Double.parseDouble(scanner.nextLine());

        sum = Math.floor(sum * 100);
        int coinsCounter = 0;


        while (sum > 0) {
            if (sum >= 200) {
                coinsCounter++;
                sum -= 200;
            } else if (sum >= 100) {
                coinsCounter++;
                sum -= 100;
            } else if (sum >= 50) {
                coinsCounter++;
                sum -= 50;
            } else if (sum >= 20) {
                coinsCounter++;
                sum -= 20;
            } else if (sum >= 10) {
                coinsCounter++;
                sum -= 10;
            } else if (sum >= 5) {
                coinsCounter++;
                sum -= 5;
            } else if (sum >= 2) {
                coinsCounter++;
                sum -= 2;
            } else if (sum >= 1) {
                coinsCounter++;
                sum -= 1;
            }
        }

        System.out.println(coinsCounter);
    }
}
