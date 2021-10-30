package ForLoop.MoreExercises;

import java.util.Scanner;

public class P07FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int stadiumCapacity = Integer.parseInt(scanner.nextLine());
        int allFansNumber = Integer.parseInt(scanner.nextLine());

        double sectorA = 0;
        double sectorB = 0;
        double sectorV = 0;
        double sectorG = 0;


        for (int i = 0; i < allFansNumber; i++) {
            String sector = scanner.nextLine();

            if (sector.equals("A")) {
                sectorA++;

            } else if (sector.equals("B")) {
                sectorB++;

            } else if (sector.equals("V")) {
                sectorV++;

            } else if (sector.equals("G")) {
                sectorG++;

            }

        }

        System.out.printf("%.2f%%", sectorA / allFansNumber * 100);
        System.out.printf("\n%.2f%%", sectorB / allFansNumber * 100);
        System.out.printf("\n%.2f%%", sectorV / allFansNumber * 100);
        System.out.printf("\n%.2f%%", sectorG / allFansNumber * 100);
        System.out.printf("\n%.2f%%", (1.0 * allFansNumber / stadiumCapacity * 100));

    }
}
