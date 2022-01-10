package L02Encapsulation.Exercise.P04PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return this.weight * 2 * getModifierByFlourType(this.flourType) * getModifierByBakingTechnique(this.bakingTechnique);
    }

    private double getModifierByFlourType(String flourType) {

        switch (flourType) {
            case "White":
                return DoughModifier.WHITE.getDoughModifier();
            case "Wholegrain":
                return DoughModifier.WHOLEGRAIN.getDoughModifier();
        }

        return 0;
    }

    private double getModifierByBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
                return DoughModifier.CRISPY.getDoughModifier();
            case "Chewy":
                return DoughModifier.CHEWY.getDoughModifier();
            case "Homemade":
                return DoughModifier.HOMEMADE.getDoughModifier();
        }
        return 0;
    }
}
