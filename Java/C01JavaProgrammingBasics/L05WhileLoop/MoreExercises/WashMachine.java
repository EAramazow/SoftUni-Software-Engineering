package WhileLoop.MoreExercises;

import java.util.Scanner;

public class WashMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bottles = Integer.parseInt(scanner.nextLine());


        int allVolumeBottles = bottles * 750;
        int counter = 0;
        int dishML = 0;
        int potML = 0;
        int oneDishML = 5;
        int onePotML = 15;
        int potCounter = 0;
        int dishCounter = 0;
        int allSum = 0;
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            int number = Integer.parseInt(input);
            counter++;

            if (counter % 3 == 0) {
                potML = number * onePotML;
                potCounter += number;
                allSum += potML;

            } else {
                dishML = number * oneDishML;
                dishCounter += number;
                allSum += dishML;
            }

            if (allSum > allVolumeBottles) {
                System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(allSum - allVolumeBottles));
                break;


            }

            input = scanner.nextLine();


        }
        if (input.equals("End")) {

            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.", dishCounter, potCounter);
            System.out.printf("\nLeftover detergent %d ml.", Math.abs(allVolumeBottles - allSum));


        }


    }
}