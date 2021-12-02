package dataTypesAndVariables.Lab;

import java.util.Scanner;

public class P06CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstSymbol = scanner.next().charAt(0);
        char secondSymbol = scanner.next().charAt(0);
        char thirdSymbol = scanner.next().charAt(0);

        System.out.printf("%c%c%c", firstSymbol, secondSymbol, thirdSymbol);
    }
}
