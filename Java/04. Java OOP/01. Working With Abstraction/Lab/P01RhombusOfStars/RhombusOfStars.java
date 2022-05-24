package L01WorkingWithAbstraction.Lab.P01RhombusOfStars;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        printRhombus(n);


    }

    private static void printRhombus(int n) {
        //print topHalf
        printTopHalf(n);

        //print middleHalf
        printMiddleHalf(n);


        //print bottomHalf
        printBottomHalf(n);
    }

    private static void printTopHalf(int n) {
        for (int r = 1; r < n; r++) {
            for (int i = 0; i < n - r; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < r; i++) {

                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printMiddleHalf(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printBottomHalf(int n) {
        for (int r = 1; r < n; r++) {
            for (int i = 0; i < r; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < n - r; i++) {

                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
