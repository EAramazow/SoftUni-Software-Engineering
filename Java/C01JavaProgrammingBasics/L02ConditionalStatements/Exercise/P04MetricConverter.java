package ConditionalStatements.Exercise;

import java.util.Scanner;

public class P04MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        String entry = scanner.nextLine();
        String exit = scanner.nextLine();

        //По този начин елиминираме редове проверки!

        //entry  -> mm, cm, m
        //exit -> mm, cm, m

        // Преобразуване на входа в метри

        if (entry.equals("mm")) {
            number = number / 1000;

        } else if (entry.equals("cm")){
            number = number / 100;
        }

        // Конвентиране на entry -> exit
        if (exit.equals("mm")) {
            number = number * 1000;

        }else if (exit.equals("cm")) {
            number = number * 100;

        }
        System.out.printf("%.3f", number);
    }
}