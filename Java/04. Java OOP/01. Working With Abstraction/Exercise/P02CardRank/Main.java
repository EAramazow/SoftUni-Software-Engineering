package L01WorkingWithAbstraction.Exercise.P02CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.printf("Card Ranks:%n", input);

        for (CardRank value : CardRank.values()) {
            System.out.printf("Ordinal value: %s; Name value: %s%n", value.ordinal(),value.name());
        }
    }
}
