package ForLoop.MoreExercises;

import java.util.Scanner;

public class P05IntervalGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int moves = Integer.parseInt(scanner.nextLine());


        double num1 = 0;
        double num2 = 0;
        double num3 = 0;
        double num4 = 0;
        double num5 = 0;
        double value = 0;
        double invalidNum = 0;
        double sum = 0;


        for (int i = 1; i <= moves; i++) {
            double intervalNumbers = Integer.parseInt(scanner.nextLine());

            if (intervalNumbers >= 0 && intervalNumbers <= 9) { // 20% from number
                num1++;
                value = intervalNumbers * 0.20;
                sum += value;


            } else if (intervalNumbers >= 10 && intervalNumbers <= 19) { // 30% from number

                num2++;
                value = intervalNumbers * 0.30;
                sum += value;

            } else if (intervalNumbers >= 20 && intervalNumbers <= 29) { // 40 % from number
                num3++;
                value = intervalNumbers * 0.40;
                sum += value;

            } else if (intervalNumbers >= 30 && intervalNumbers <= 39) { // 50 points
                value = 50;
                sum += value;
                num4++;

            } else if (intervalNumbers >= 40 && intervalNumbers <= 50) { // 100 points
                value = 100;
                sum += value;
                num5++;

            } else { // резултата се дели на 2 (числото е невалидно)
                sum /= 2;
                invalidNum++;

            }
        }

        System.out.printf("%.2f", sum);
        System.out.printf("\nFrom 0 to 9: %.2f%%", num1 / moves * 100);
        System.out.printf("\nFrom 10 to 19: %.2f%%", num2 / moves * 100);
        System.out.printf("\nFrom 20 to 29: %.2f%%", num3 / moves * 100);
        System.out.printf("\nFrom 30 to 39: %.2f%%", num4 / moves * 100);
        System.out.printf("\nFrom 40 to 50: %.2f%%", num5 / moves * 100);
        System.out.printf("\nInvalid numbers: %.2f%%", invalidNum / moves * 100);
    }
}