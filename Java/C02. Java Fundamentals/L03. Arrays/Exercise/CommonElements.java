package arrays.Exercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");

        for (String secondWord : secondArray) {
            for (String firstWord : firstArray) {
                if (secondWord.equals(firstWord)) {
                    System.out.print(firstWord + " ");
                }

            }
        }


    }
}
