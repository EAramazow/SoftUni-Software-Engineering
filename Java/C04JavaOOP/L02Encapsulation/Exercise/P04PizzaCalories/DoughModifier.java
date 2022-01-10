package L02Encapsulation.Exercise.P04PizzaCalories;

public enum DoughModifier {
    WHITE(1.5),
    WHOLEGRAIN(1.0),

    CRISPY(0.9),
    CHEWY(1.1),
    HOMEMADE(1.0);

    private double doughModifier;


    DoughModifier(double doughModifier) {
        this.doughModifier = doughModifier;
    }


    public double getDoughModifier() {
        return this.doughModifier;
    }
}
