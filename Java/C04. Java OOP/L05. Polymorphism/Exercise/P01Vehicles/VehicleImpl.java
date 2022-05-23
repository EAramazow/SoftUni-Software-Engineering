package L05Polymorphism.Exercise.P01Vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicles {
    private double fuelQuantity;
    private double fuelConsumption;

    public VehicleImpl(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

    @Override
    public String driving(double distance) {
        double fuelNeeded = distance * getFuelConsumption();
        if (fuelNeeded > getFuelQuantity()) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuelNeeded);
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s travelled %s km",this.getClass().getSimpleName(), formatter.format(distance));
    }

    @Override
    public void refueling(double liters) {
        this.fuelQuantity += liters;
    }


    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }


}
