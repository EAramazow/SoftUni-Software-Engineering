package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class P08CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double r = Double.parseDouble(scanner.nextLine());

        // лице

        System.out.printf("%.2f", r * r * Math.PI);

        // параметър (обиколка или дължина)

        System.out.printf("\n%.2f", 2 * r * Math.PI);

    }
}
