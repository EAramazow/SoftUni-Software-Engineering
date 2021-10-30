package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String kindOfGroup = scanner.nextLine();
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        int numberOfNights = Integer.parseInt(scanner.nextLine());


        String sport = "";
        double price = 0;

        switch (season) {
            case "Winter":
                if (kindOfGroup.equals("girls")) {
                    sport = "Gymnastics";
                    price = numberOfNights * numberOfStudents * 9.60;
                } else if (kindOfGroup.equals("boys")) {
                    sport = "Judo";
                    price = numberOfNights * numberOfStudents * 9.60;
                } else if (kindOfGroup.equals("mixed")) {
                    sport = "Ski";
                    price = numberOfNights * numberOfStudents * 10;
                }
                break;

            case "Spring":
                if (kindOfGroup.equals("girls")) {
                    sport = "Athletics";
                    price = numberOfNights * numberOfStudents * 7.20;
                } else if (kindOfGroup.equals("boys")) {
                    sport = "Tennis";
                    price = numberOfNights * numberOfStudents * 7.20;
                } else if (kindOfGroup.equals("mixed")) {
                    sport = "Cycling";
                    price = numberOfNights * numberOfStudents * 9.50;
                }
                break;

            case "Summer":
                if (kindOfGroup.equals("girls")) {
                    sport = "Volleyball";
                    price = numberOfNights * numberOfStudents * 15;
                } else if (kindOfGroup.equals("boys")) {
                    sport = "Football";
                    price = numberOfNights * numberOfStudents * 15;
                } else if (kindOfGroup.equals("mixed")) {
                    sport = "Swimming";
                    price = numberOfNights * numberOfStudents * 20;
                }
                break;
        }

        if (numberOfStudents >= 50) {
            price *= 0.50;
        } else if (numberOfStudents >= 20) {
            price *= 0.85;
        } else if (numberOfStudents >= 10) {
            price *= 0.95;
        }

        System.out.printf("%s %.2f lv.", sport, price);


    }

}
