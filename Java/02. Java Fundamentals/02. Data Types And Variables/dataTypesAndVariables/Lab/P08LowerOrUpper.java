package dataTypesAndVariables.Lab;

import java.util.Scanner;

public class P08LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstChar = scanner.nextLine();

        if (firstChar.equals(firstChar.toUpperCase())) {
            System.out.println("upper-case");
        } else if (firstChar.equals(firstChar.toLowerCase())) {
            System.out.println("lower-case");
        }


    }
}
