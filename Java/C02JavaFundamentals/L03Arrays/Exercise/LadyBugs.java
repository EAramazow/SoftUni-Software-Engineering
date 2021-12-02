package arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] fieldArray = new int[fieldSize];

        int[] LadyBugsIndexes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int ladyBugIndex : LadyBugsIndexes) {
            if (ladyBugIndex >= 0 && ladyBugIndex <= fieldArray.length - 1) {
                fieldArray[ladyBugIndex] = 1;

            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {


            String[] tokens = command.split(" ");
            int index = Integer.parseInt(tokens[0]);
            String direction = tokens[1];
            int flyLength = Integer.parseInt(tokens[2]);

            if (index >= 0 && index <= fieldArray.length - 1 && fieldArray[index] == 1) {

                fieldArray[index] = 0;
                if (direction.equals("right")) {


                    index += flyLength;
                    while (index <= fieldArray.length - 1 && fieldArray[index] == 1) {
                        index += flyLength;
                    }
                    if (index <= fieldArray.length - 1) {
                        fieldArray[index] = 1;
                    }

                } else if (direction.equals("left")) {

                    index -= flyLength;
                    while (index >= 0 && fieldArray[index] == 1) {
                        index -= flyLength;
                    }
                    if (index >= 0) {
                        fieldArray[index] = 1;
                    }

                }
            }


            command = scanner.nextLine();
        }
        for (int number : fieldArray) {
            System.out.print(number + " ");

        }

    }
}
