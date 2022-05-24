package ConditionalStatements.Lab;

import java.util.Scanner;

public class P06AreOfFigures {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String figures = scanner.nextLine();

        if (figures.equalsIgnoreCase("square")) {
            double a = Double.parseDouble(scanner.nextLine());
            double area = a * a;
            System.out.printf("%.3f", area);

        } else if (figures.equalsIgnoreCase("rectangle")) {
            double a = Double.parseDouble(scanner.nextLine());
            double b = Double.parseDouble(scanner.nextLine());
            double area = a * b;
            System.out.printf("%.3f", area);

            } else if (figures.equalsIgnoreCase("circle")) {
            double r = Double.parseDouble(scanner.nextLine());
            double area = Math.PI * r * r;
            System.out.printf("%.3f", area);

        } else if (figures.equalsIgnoreCase("triangle")) {

            double a = Double.parseDouble(scanner.nextLine());
            double h = Double.parseDouble(scanner.nextLine());
            double area = a * h / 2;
            System.out.printf("%.3f", area);

        }


    }
}
