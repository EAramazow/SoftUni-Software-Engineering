package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class P01PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int volume = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double hours = Double.parseDouble(scanner.nextLine());


        double pipe1Liters = p1 * hours;   // 300 liters
        double pipe2Liters = p2 * hours;   // 360 liters

        double waterSum = pipe1Liters + pipe2Liters;   // 660 liters from 1000 liters

        if (waterSum <= volume) {

            double percentFull = waterSum/volume * 100;
            double percentPipe1 = pipe1Liters/waterSum * 100;
            double percentPipe2 = pipe2Liters/waterSum * 100;


            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.", percentFull, percentPipe1, percentPipe2);

        } else {
            double overflow = waterSum - volume;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", hours, overflow);


        }



    }
}
