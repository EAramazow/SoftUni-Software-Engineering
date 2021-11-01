package basicSyntaxConditionalStatementsLoops.Lab;

import java.util.Scanner;

public class TheatrePromotions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int price = 0;


        switch (typeOfDay) {
            case "Weekday":
                if (age >= 0 && age <= 18) {
                    price = 12;
                    System.out.println(price + "$");
                } else if (age > 18 && age <= 64) {
                    price = 18;
                    System.out.println(price + "$");
                } else if (age > 64 && age <= 122) {
                    price = 12;
                    System.out.println(price + "$");
                } else {
                    System.out.println("Error!");
                }
                break;

            case "Weekend":
                if (age >= 0 && age <= 18) {
                    price = 15;
                    System.out.println(price + "$");
                } else if (age > 18 && age <= 64) {
                    price = 20;
                    System.out.println(price + "$");
                } else if (age > 64 && age <= 122) {
                    price = 15;
                    System.out.println(price + "$");
                } else {
                    System.out.println("Error!");
                }
            break;

            case "Holiday":
                if (age >= 0 && age <= 18) {
                    price = 5;
                    System.out.println(price + "$");
                } else if (age > 18 && age <= 64) {
                    price = 12;
                    System.out.println(price + "$");
                } else if (age > 64 && age <= 122) {
                    price = 10;
                    System.out.println(price + "$");
                } else {
                    System.out.println("Error!");
                }
            }

        }
    }
