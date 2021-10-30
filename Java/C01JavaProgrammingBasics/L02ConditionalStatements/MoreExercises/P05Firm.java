package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class P05Firm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int countEmployeesOvertime = Integer.parseInt(scanner.nextLine());


        double training = days * 0.9;
        double hoursAfterTraining = training * 8;
        double overTime = countEmployeesOvertime * 2 * days;


        double allHours = Math.floor(hoursAfterTraining + overTime);


        if (allHours >= hours) {
            System.out.printf("Yes!%.0f hours left.", Math.abs(allHours - hours));


        } else if (allHours <= hours) {

            System.out.printf("Not enough time!%.0f hours needed.", Math.abs(hours - allHours));
        }

    }
}
