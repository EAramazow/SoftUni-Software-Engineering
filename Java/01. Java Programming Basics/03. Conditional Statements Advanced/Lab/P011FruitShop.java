package ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class P011FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double result = 0;

        if ("Monday".equals(day) ||
                "Tuesday".equals(day) ||
                "Wednesday".equals(day) ||
                "Thursday".equals(day) ||
                "Friday".equals(day)) {
            if ("banana".equals(fruit)) {
                result = quantity * 2.50;
            } else if ("apple".equals(fruit)) {
                result = quantity * 1.20;
            } else if ("orange".equals(fruit)) {
                result = quantity * 0.85;
            } else if ("grapefruit".equals(fruit)) {
                result = quantity * 1.45;
            } else if ("kiwi".equals(fruit)) {
                result = quantity * 2.70;
            } else if ("pineapple".equals(fruit)) {
                result = quantity * 5.50;
            } else if ("grapes".equals(fruit)) {
                result = quantity * 3.85;
            }
            }
        else if ("Saturday".equals(day) || "Sunday".equals(day)) {

            if ("banana".equals(fruit)) {
                result = quantity * 2.70;
            } else if ("apple".equals(fruit)) {
                result = quantity * 1.25;
            } else if ("orange".equals(fruit)) {
                result = quantity * 0.90;
            } else if ("grapefruit".equals(fruit)) {
                result = quantity * 1.60;
            } else if ("kiwi".equals(fruit)) {
                result = quantity * 3.00;
            } else if ("pineapple".equals(fruit)) {
                result = quantity * 5.60;
            } else if ("grapes".equals(fruit)) {
                result = quantity * 4.20;
            }
            }
      if (result > 0) {
        System.out.printf("%.2f", result);
    } else {
        System.out.println("error");
    }
    }
}
