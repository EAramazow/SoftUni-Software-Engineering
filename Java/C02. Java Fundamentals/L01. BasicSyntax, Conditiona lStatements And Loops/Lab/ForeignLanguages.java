package basicSyntaxConditionalStatementsLoops.Lab;

import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();

        if (country.equals("England")) {
            System.out.println("English");
        } else if (country.equals("USA")) {
            System.out.println("English");
        } else if (country.equals("Spain")) {
            System.out.println("Spanish");
        } else if (country.equals("Argentina")) {
            System.out.println("Spanish");
        } else if (country.equals("Mexico")) {
            System.out.println("Spanish");
        } else {
            System.out.println("unknown");
        }
    }
}
