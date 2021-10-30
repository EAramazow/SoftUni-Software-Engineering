package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class P07HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        // Стени
        double sideWall = x * y;
        double window = 1.5 * 1.5;

        double allSideWalls = (2 * sideWall) - (2 * window);

        double backWall = x * x;
        double door = 1.2 * 2;
        double frontAndBackWalls = 2 * backWall - door;

        double sumWalls = allSideWalls + frontAndBackWalls;

        double greenPaint = sumWalls / 3.4;


        // покрив

        double roof = 2 * (x * y);
        double triangles = 2 * (x * h / 2);
        double sumRoof = roof + triangles;

        double redPaint = sumRoof / 4.3;

        System.out.printf("%.2f", greenPaint);
        System.out.printf("\n%.2f", redPaint);


    }
}
