package ConditionalStatements.Exercise;

import java.util.Scanner;

public class P07SwimmingPool2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double time = Double.parseDouble(scanner.nextLine());

        double timeNeeded = distance*time;

        double delay = Math.floor(distance/15) * 12.5;

        double allTime = timeNeeded+delay;

        double difference = Math.abs(allTime-record);

        if (record<=allTime) {
            System.out.printf("No, he failed! He was %.2f seconds slower.", difference);
        } else {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", allTime);
        }
    }
}