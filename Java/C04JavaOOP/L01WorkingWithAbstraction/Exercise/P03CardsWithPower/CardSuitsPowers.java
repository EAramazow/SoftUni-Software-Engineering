package L01WorkingWithAbstraction.Exercise.P03CardsWithPower;

public enum CardSuitsPowers {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int suitPower;

    CardSuitsPowers(int suitPower) {
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return suitPower;
    }
}
