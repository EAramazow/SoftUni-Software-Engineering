package arrays.Lab;

import java.util.Scanner;

public class P01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int currentDay = Integer.parseInt(scanner.nextLine());

        if (currentDay >= 1 && currentDay <= 7) {
            System.out.println(days[currentDay - 1]);

        } else {
            System.out.println("Invalid day!");
        }


    }
}
