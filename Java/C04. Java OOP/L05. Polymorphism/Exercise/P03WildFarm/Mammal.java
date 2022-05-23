package L05Polymorphism.Exercise.P03WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    String livingRegion;

    public Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]", getAnimalType(), getAnimalName(),
                formatter.format(getAnimalWeight()), this.livingRegion, getFoodEaten());
    }

    public String getLivingRegion() {
        return livingRegion;
    }
}
