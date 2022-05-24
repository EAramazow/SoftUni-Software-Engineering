package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class MultiplyBy2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());
        boolean isTrue = true;

        while (isTrue) {


            if (input < 0) {
                System.out.println("Negative number!");
                break;
            }


            System.out.printf("Result: %.2f\n", input * 2);
            input = Double.parseDouble(scanner.nextLine());

        }
    }
}
