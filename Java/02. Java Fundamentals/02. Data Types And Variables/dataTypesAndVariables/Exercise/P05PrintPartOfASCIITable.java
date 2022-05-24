package dataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P05PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int last = Integer.parseInt(scanner.nextLine());

        for (int number = start; number <= last; number++) {

       //     System.out.print((char) number + " ");   // печата char символа на числото

            System.out.printf("%c ", number);          // може и с шаблон

        }
    }
}
