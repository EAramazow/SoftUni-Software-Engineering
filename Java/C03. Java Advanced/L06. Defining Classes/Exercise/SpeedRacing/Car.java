package DefiningClasses.Exercise.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double consumption;
    private double distanceTraveled;

    public Car(String model, double fuelAmount, double consumption) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.consumption = consumption;
        this.distanceTraveled = 0;
    }

    public boolean drive(double kilometersToDrive) {
        double fuelRequired = kilometersToDrive * consumption;
        if (fuelRequired > fuelAmount) {
            return false;
        } else {
            this.fuelAmount -= fuelRequired;
            this.distanceTraveled += kilometersToDrive;
            return true;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
