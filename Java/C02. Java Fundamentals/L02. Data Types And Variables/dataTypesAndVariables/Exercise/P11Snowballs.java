package dataTypesAndVariables.Exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class P11Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double maxSnowValue = Double.MIN_VALUE;
        int maxSnowTime = Integer.MIN_VALUE;
        int maxSnowQuality = Integer.MIN_VALUE;
        int maxSnow = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {


            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double snowballValue = Math.pow((snowballSnow * 1.0 / snowballTime), snowballQuality);

            if (snowballValue > maxSnowValue) {
                maxSnow = snowballSnow;
                maxSnowTime = snowballTime;
                maxSnowQuality = snowballQuality;
                maxSnowValue = snowballValue;
            }


        }
        System.out.printf("%d : %d = %.0f (%d)", maxSnow, maxSnowTime, maxSnowValue, maxSnowQuality);

    }
}
