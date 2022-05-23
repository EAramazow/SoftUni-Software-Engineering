package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class P02SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int offDays = Integer.parseInt(scanner.nextLine());


        int time = 30000;


        int workDays = 365 - offDays;
        int minutesPlay = ((workDays * 63) + (offDays * 127));
        int hours = Math.abs((time - minutesPlay) / 60);
        int minutes = Math.abs((time - minutesPlay) % 60);


        if (minutesPlay > time) {

            System.out.printf("Tom will run away\n%d hours and %d minutes more for play", hours, minutes);
        } else {

            System.out.printf("Tom sleeps well\n%d hours and %d minutes less for play", hours, minutes);
        }

    }
}
