package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P01Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projection = scanner.nextLine();
        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        double price = 0;
        int seats = 0;
        double allSum = 0;

        switch (projection) {
            case "Premiere":
                price = 12.00;
                seats = c * r;
                allSum = price * seats;
                break;

            case "Normal":
                price = 7.50;
                seats = c * r;
                allSum = price * seats;
                break;

            case "Discount":
                price = 5.00;
                seats = c * r;
                allSum = price * seats;
                break;
        }

        System.out.printf("%.2f", allSum);

    }
}
