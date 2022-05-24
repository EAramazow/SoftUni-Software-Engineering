package methods.MoreExercise;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String number = scanner.nextLine();


        if (input.equals("int")) {
            int num = Integer.parseInt(number);
            integerType(num);
        } else if (input.equals("real")) {
            double num = Double.parseDouble(number);
            realType(num);
        } else if (input.equals("string")) {
            stringType(number);
        }


    }

    private static void integerType(int number) {
        int result = number * 2;
        System.out.println(result);
    }

    private static void realType(double number) {
        double result = number * 1.5;
        System.out.printf("%.2f", result);
    }

    private static void stringType(String input) {
        System.out.printf("$%s$", input);
    }
}
