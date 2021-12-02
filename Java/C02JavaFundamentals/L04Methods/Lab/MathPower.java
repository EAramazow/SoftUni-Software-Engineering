package methods.Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = Double.parseDouble(scanner.nextLine());
        double power = Double.parseDouble(scanner.nextLine());

        System.out.println(new DecimalFormat("0.####").format(mathOperations(firstNum, power)));

    }

    private static double mathOperations(double firstNum, double power) {
        double result = Math.pow(firstNum, power);
        return result;
    }
}
