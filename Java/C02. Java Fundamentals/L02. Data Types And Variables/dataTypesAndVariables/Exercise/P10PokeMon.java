package dataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int powerN = Integer.parseInt(scanner.nextLine());
        int distanceM = Integer.parseInt(scanner.nextLine());
        int exhaustionFactorY = Integer.parseInt(scanner.nextLine());

        int countTargets = 0;
        double percent = (double) powerN * 0.5;

        while (powerN >= distanceM) {
            powerN -= distanceM;
            countTargets++;


            if (powerN == percent && exhaustionFactorY != 0) {
                powerN /= exhaustionFactorY;
            }

        }

        System.out.println(powerN);
        System.out.println(countTargets);
    }


}


