package WhileLoop.MoreExercises;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double sumNum = 0;
        double divide = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

                sumNum += number;
        }
        divide = sumNum / n;

        System.out.printf("%.2f", divide);
    }
}
