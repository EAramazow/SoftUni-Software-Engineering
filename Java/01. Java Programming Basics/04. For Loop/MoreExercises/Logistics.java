package ForLoop.MoreExercises;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cargoNumber = Integer.parseInt(scanner.nextLine());


        double microbus = 200;
        double truck = 175;
        double train = 120;

        double sumMicrobus = 0;
        double sumTruck = 0;
        double sumTrain = 0;
        double allSum = 0;

        int truckWeight = 0;
        int microbusWeight = 0;
        int trainWeight = 0;

        for (int i = 1; i <= cargoNumber ; i++) {
            int cargoTones = Integer.parseInt(scanner.nextLine());

            if (cargoTones <= 3) {
                sumMicrobus += cargoTones * microbus;
                microbusWeight += cargoTones;
            } else if (cargoTones > 4 && cargoTones <= 11) {
                sumTruck += cargoTones * truck;
                truckWeight += cargoTones;
            } else {
                sumTrain += cargoTones * train;
                trainWeight += cargoTones;
            }

            allSum += cargoTones;




        }
    }
}
