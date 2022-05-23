package NestedLoops.Exercises;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int numCounter = 0;
        boolean isEqual = false;

        for (int rows = 1; rows <= n; rows++) {

            for (int col = 1; col <= rows; col++) {
                numCounter++;
                System.out.print(numCounter + " ");
                if (numCounter >= n) {
                    isEqual = true; // за да подскажем на външния цикъл кога да го брейкнем
                    break;
                }
            }
            // прекъсваме външния цикъл с нова проверка
            if (isEqual) {
                break;
            }
            System.out.println(); // за празен ред
        }
    }

}
