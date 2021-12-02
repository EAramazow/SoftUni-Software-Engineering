package arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int counter = 0;
        int bestIndex = 0;
        int bestSequence = 0;
        int bestSum = 0;
        int bestCount = 0;
        int[] bestDNA = new int[n];


        while (!input.equals("Clone them!")) {
            int[] currentDNAArray = Arrays.stream(input.split("!"))
                    .mapToInt(Integer::parseInt).toArray();

            int currentSum = 0, currentSequence = 0, currentIndex = 0;
            counter++;

            for (int sum : currentDNAArray) {
                if (sum == 1) {
                    currentSum++;
                }
            }

            for (int i = 0; i < currentDNAArray.length - 1; i++) {
                if (currentDNAArray[i] == currentDNAArray[i + 1] && currentDNAArray[i] == 1) {
                    currentSequence++;
                    currentIndex = i;
                }
            }


            if ((currentSequence > bestSequence) || ((currentSequence == bestSequence) && (currentIndex < bestIndex))
                    || ((currentSequence == bestSequence) && (currentIndex == bestIndex) && (currentSum > bestSum))) {

                bestCount = counter;
                bestSequence = currentSequence;
                bestIndex = currentIndex;
                bestSum = currentSum;
                bestDNA = currentDNAArray;
            }


            input = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.\n", bestCount, bestSum);

        for (int best : bestDNA) {
            System.out.print(best + " ");

        }


    }


}
