package ConditionalStatements.Exercise;

import java.util.Scanner;

public class P07SwimmingPool {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double recordSeconds = Double.parseDouble(scanner.nextLine());
        double distanceMeters = Double.parseDouble(scanner.nextLine());
        double timeSecondsForMeter = Double.parseDouble(scanner.nextLine());

        // 1. Проверка дали Иван е подобрил световният рекорд
        // 2. Проверка дали НЕ Е УСПЯЛ да подобри световният рекорд

        double swimTime = distanceMeters * timeSecondsForMeter;
        double resistanceWater = Math.floor(distanceMeters / 15) * 12.5;


        double totalTime = swimTime + resistanceWater;


        double differenceTime = Math.abs(totalTime - recordSeconds);

        if (recordSeconds <= totalTime) {

            System.out.printf("No, he failed! He was %.2f seconds slower.", differenceTime);
        } else {

            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
        }


    }
}
