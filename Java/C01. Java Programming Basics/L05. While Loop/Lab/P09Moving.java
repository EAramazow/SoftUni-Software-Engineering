package WhileLoop.Lab;

import java.util.Scanner;

public class P09Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());


        int volumeHouse = width * length * height;
        String input = scanner.nextLine();
        int sumAllBoxes = 0;

        while (!input.equals("Done")) {
            int boxes = Integer.parseInt(input);

            sumAllBoxes += boxes;

            if (sumAllBoxes >= volumeHouse) {
                break;

            }

            input = scanner.nextLine();


        }
        int difference = Math.abs(sumAllBoxes - volumeHouse);
        if (sumAllBoxes >= volumeHouse) {
            System.out.printf("No more free space! You need %d Cubic meters more.", difference);
        } else {
            System.out.printf("%d Cubic meters left.", difference);

        }
    }
}
