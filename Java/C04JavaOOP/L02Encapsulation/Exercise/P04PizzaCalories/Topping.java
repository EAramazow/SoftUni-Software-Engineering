package L02Encapsulation.Exercise.P04PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;


    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies") && !toppingType.equals("Cheese")
                && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", weight));
        }
        this.weight = weight;
    }


    private double getModifierByToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
                return ToppingModifier.MEAT.getToppingModifier();
            case "Veggies":
                return ToppingModifier.VEGGIES.getToppingModifier();
            case "Cheese":
                return ToppingModifier.CHEESE.getToppingModifier();
            case "Sauce":
                return ToppingModifier.SAUCE.getToppingModifier();
        }
        return 0;
    }

    public double calculateCalories() {
        return this.weight * 2 * this.getModifierByToppingType(this.toppingType);
    }

}
