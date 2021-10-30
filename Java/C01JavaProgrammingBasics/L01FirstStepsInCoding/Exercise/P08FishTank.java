package FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class P08FishTank {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double capacity = length * width * height;
        double liters = capacity * 0.001;
        double percent2 = percent * 0.01;
        double realLiters = liters * (1 - percent2);

        System.out.printf("%.2f", realLiters);


    }
}
