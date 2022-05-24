package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String gas = scanner.nextLine();
        double liters = Double.parseDouble(scanner.nextLine());

        if (gas.equals("Diesel")) {
            if (liters >= 25) {
                System.out.printf("You have enough %s.", gas.toLowerCase());
            } else if (liters < 25) {
                System.out.printf("Fill your tank with %s!", gas.toLowerCase());
            }
        } else if (gas.equals("Gasoline")) {
            if (liters >= 25) {
                System.out.printf("You have enough %s.", gas.toLowerCase());

            } else if (liters < 25) {
                System.out.printf("Fill your tank with %s!", gas.toLowerCase());

            }
        } else if (gas.equals("Gas")) {
            if (liters >= 25) {
                System.out.printf("You have enough %s.", gas.toLowerCase());

            } else if (liters < 25) {
                System.out.printf("Fill your tank with %s!", gas.toLowerCase());

            }
        } else {
            System.out.printf("Invalid fuel!", gas.toLowerCase());
        }
    }
}
