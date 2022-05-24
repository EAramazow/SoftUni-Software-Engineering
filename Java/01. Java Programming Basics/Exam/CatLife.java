package Exam24April2021;

import java.util.Scanner;

public class CatLife {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String catBreed = scanner.nextLine();
        char symbol = scanner.next().charAt(0);

        double months = 0;
        double catMonths = 0;


        switch (symbol) {
            case 'm':
                if (catBreed.equals("British Shorthair")) {
                    months = 13 * 12;
                    catMonths = months / 6;
                    System.out.printf("%.0f cat months", Math.floor(catMonths));

                } else if (catBreed.equals("Siamese")) {
                    months = 15 * 12;
                    catMonths = months / 6;
                    System.out.printf("%.0f cat months", Math.floor(catMonths));

                } else if (catBreed.equals("Persian")) {
                    months = 14 * 12;
                    catMonths = months / 6;
                    System.out.printf("%.0f cat months", Math.floor(catMonths));

                } else if (catBreed.equals("Ragdoll")) {
                    months = 16 * 12;
                    catMonths = months / 6;
                    System.out.printf("%.0f cat months", Math.floor(catMonths));

                } else if (catBreed.equals("American Shorthair")) {
                    months = 12 * 12;
                    catMonths = months / 6;
                    System.out.printf("%.0f cat months", Math.floor(catMonths));

                } else if (catBreed.equals("Siberian")) {
                    months = 11 * 12;
                    catMonths = months / 6;
                    System.out.printf("%.0f cat months", Math.floor(catMonths));

                } else {
                    System.out.printf("%s is invalid cat!", catBreed);
                }
                break;

            case 'f':
                if (catBreed.equals("British Shorthair")) {
                    months = 14 * 12;
                    catMonths = months / 6;
                    System.out.printf("%.0f cat months", Math.floor(catMonths));

                } else if (catBreed.equals("Siamese")) {
                    months = 16 * 12;
                    catMonths = months / 6;
                    System.out.printf("%.0f cat months", Math.floor(catMonths));

                } else if (catBreed.equals("Persian")) {
                    months = 15 * 12;
                    catMonths = months / 6;
                    System.out.printf("%.0f cat months", Math.floor(catMonths));

                } else if (catBreed.equals("Ragdoll")) {
                    months = 17 * 12;
                    catMonths = months / 6;
                    System.out.printf("%.0f cat months", Math.floor(catMonths));

                } else if (catBreed.equals("American Shorthair")) {
                    months = 13 * 12;
                    catMonths = months / 6;
                    System.out.printf("%.0f cat months", Math.floor(catMonths));

                } else if (catBreed.equals("Siberian")) {
                    months = 12 * 12;
                    catMonths = months / 6;
                    System.out.printf("%.0f cat months", Math.floor(catMonths));

                } else {
                    System.out.printf("%s is invalid cat!", catBreed);
                }
                break;


        }

    }


}

