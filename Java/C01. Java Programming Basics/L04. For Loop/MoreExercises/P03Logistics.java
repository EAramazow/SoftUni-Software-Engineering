package ForLoop.MoreExercises;

import java.util.Scanner;

public class P03Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCargo = Integer.parseInt(scanner.nextLine());


        int bus = 0;
        int truck = 0;
        int train = 0;
        double allCargo = 0;


        for (int i = 0; i < countCargo; i++) {
            int tonesCargo = Integer.parseInt(scanner.nextLine());

            allCargo += tonesCargo;

            if (tonesCargo <= 3) {
                bus += tonesCargo;


            } else if (tonesCargo >= 4 && tonesCargo <= 11) {
                truck += tonesCargo;


            } else if (tonesCargo >= 12) {
                train += tonesCargo;

            }

        }

        System.out.printf("%.2f", (bus * 200 + truck * 175 + train * 120) / allCargo);
        System.out.printf("\n%.2f%%", bus / allCargo * 100);
        System.out.printf("\n%.2f%%", truck / allCargo * 100);
        System.out.printf("\n%.2f%%", train / allCargo * 100);

    }
}
