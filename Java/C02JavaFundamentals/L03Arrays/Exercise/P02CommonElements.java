package arrays.Exercise;

import java.util.Scanner;

public class P02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstRow = scanner.nextLine();
        String secondRow = scanner.nextLine();

        String[] firstArray = firstRow.split(" ");
        String[] secondArray = secondRow.split(" ");

        for (String secondWord : secondArray) {
            for (String firstWord : firstArray) {

                if (secondWord.equals(firstWord)) {
                    System.out.println(firstRow + " ");
                }
            }
            
        }

    }
}
