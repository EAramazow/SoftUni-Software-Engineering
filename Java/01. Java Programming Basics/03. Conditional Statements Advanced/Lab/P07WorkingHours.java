package ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class P07WorkingHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        String day = scanner.nextLine();

        String type = "";

        if (hour >= 10 && hour <= 18) {
            if (day.equals("Monday") ||
                    day.equals("Tuesday") ||
                    day.equals("Wednesday") ||
                    day.equals("Thursday") ||
                    day.equals("Friday") ||
                    day.equals("Saturday")) {
                type = "open";

            } else {
                type = "closed";
            }

        } else {
            type = "closed";
        }
        System.out.println(type);
    }
}
