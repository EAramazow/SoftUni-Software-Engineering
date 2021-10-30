package FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class P04VacationBooksList {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberPages = Integer.parseInt(scanner.nextLine());
        int pages = Integer.parseInt(scanner.nextLine());
        int numberDays = Integer.parseInt(scanner.nextLine());

        int hours = numberPages / pages;
        int hoursPerDay = hours / numberDays;


        System.out.println(hoursPerDay);

    }
}
