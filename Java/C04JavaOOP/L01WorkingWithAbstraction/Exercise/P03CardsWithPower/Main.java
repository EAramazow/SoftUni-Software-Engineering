package L01WorkingWithAbstraction.Exercise.P03CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        CardRankPowers rank = CardRankPowers.valueOf(cardRank);
        CardSuitsPowers suits = CardSuitsPowers.valueOf(cardSuit);

        Card card = new Card(rank, suits);

        System.out.printf("Card name: %s of %s; Card power: %d", rank.name(), suits.name(), card.calculatedCards());

    }
}
