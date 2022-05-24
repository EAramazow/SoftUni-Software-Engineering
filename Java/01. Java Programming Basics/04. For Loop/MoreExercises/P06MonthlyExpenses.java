package ForLoop.MoreExercises;

import java.util.Scanner;

public class P06MonthlyExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int months = Integer.parseInt(scanner.nextLine());


        double electricity = 0;
        double water = 20;
        double internet = 15;
        double other = 0;

        double monthCounter = 0;
        double oneMonth = 0;
        double allMonths = 0;


        for (int i = 0; i < months; i++) {
            double electricityCheck = Double.parseDouble(scanner.nextLine());

            electricity += electricityCheck;
            monthCounter++;

            oneMonth = electricityCheck + water + internet;
            allMonths = oneMonth * 0.2;
            oneMonth = oneMonth + allMonths;

            other += oneMonth;


        }
        water *= monthCounter;
        internet *= monthCounter;

        System.out.printf("Electricity: %.2f lv\n", electricity);
        System.out.printf("Water: %.2f lv\n", water);
        System.out.printf("Internet: %.2f lv\n", internet);
        System.out.printf("Other: %.2f lv\n", other);
        System.out.printf("Average: %.2f lv\n", (electricity + water + internet + other) / monthCounter);
    }
}
