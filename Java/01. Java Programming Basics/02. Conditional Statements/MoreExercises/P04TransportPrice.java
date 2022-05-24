package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class P04TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kilometers = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();


        double taxiStartTariff = 0.70;
        double taxiDayTariff = kilometers * 0.79;
        double taxiNightTariff = kilometers * 0.90;


        double busTariff = kilometers * 0.09;
        double trainTariff = kilometers * 0.06;


        if (dayOrNight.equals("day") && kilometers < 20) { // day
            double taxiDay = taxiStartTariff + taxiDayTariff;
            System.out.printf("%.2f", taxiDay);

        } else if (dayOrNight.equals("night") && kilometers < 20) {
            double taxiNight = taxiStartTariff + taxiNightTariff;
            System.out.printf("%.2f", taxiNight);
        }

        if (kilometers >= 20 && kilometers < 100) {
            System.out.printf("%.2f", busTariff);

        } else if (kilometers >= 100) {
            System.out.printf("%.2f", trainTariff);

        }


    }
}


