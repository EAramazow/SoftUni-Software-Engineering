package L08ExceptionsAndErrorHandling.Demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dayAsNumber = Integer.parseInt(scanner.nextLine());


        System.out.printf("Hello, today is " + getWeek(dayAsNumber));
    }

    public static String getWeek (int dayNumber) {
        return switch (dayNumber) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> throw new IllegalArgumentException("Unknown day of week " + dayNumber);

        };
    }
}
