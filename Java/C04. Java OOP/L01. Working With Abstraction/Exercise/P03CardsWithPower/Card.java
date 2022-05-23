package L01WorkingWithAbstraction.Exercise.P03CardsWithPower;

public class Card {
    private CardRankPowers rank;
    private CardSuitsPowers suits;

    public Card(CardRankPowers rank, CardSuitsPowers suit) {
        this.rank = rank;
        this.suits = suit;
    }

    public int calculatedCards() {
        return rank.getRankPower() + suits.getSuitPower();
    }


}
