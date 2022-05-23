package L02Encapsulation.Exercise.P04PizzaCalories;

public enum ToppingModifier {
    MEAT(1.2),
    VEGGIES(0.8),
    CHEESE(1.1),
    SAUCE(0.9);

    private double toppingModifier;

    ToppingModifier(double toppingModifier) {
        this.toppingModifier = toppingModifier;
    }

    public double getToppingModifier() {
        return this.toppingModifier;
    }
}
