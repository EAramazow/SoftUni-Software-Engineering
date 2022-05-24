package DefiningClasses.Exercise.RawData;

public class Tyre {
    private double tyrePressure;
    private int tyreAge;

    public Tyre(double tyrePressure, int tyreAge) {
        this.tyrePressure = tyrePressure;
        this.tyreAge = tyreAge;
    }

    public double getTyrePressure() {
        return tyrePressure;
    }

    public int getTyreAge() {
        return tyreAge;
    }
}
