package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P09Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String year = scanner.nextLine();
        int p = Integer.parseInt(scanner.nextLine());
        int h = Integer.parseInt(scanner.nextLine());

        double volleyTime = 0;


        volleyTime += (48 - h) * 3.0 / 4;

        volleyTime += p * 2.0 / 3;

        volleyTime += h;

        if (year.equals("leap")) {
            volleyTime *= 1.15;
        }
        System.out.printf("%.0f", Math.floor(volleyTime));

    }
}
