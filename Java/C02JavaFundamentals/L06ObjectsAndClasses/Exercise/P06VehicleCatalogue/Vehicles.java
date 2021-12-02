package objectsAndClasses.Exercise.P06VehicleCatalogue;

public class Vehicles {
    private String typeVehicle;
    private String model;
    private String color;
    private int horsePower;

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public Vehicles(String typeVehicle, String model, String color, int horsePower) {
        this.typeVehicle = typeVehicle;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("Type: %s\nModel: %s\nColor: %s\nHorsepower: %d", this.typeVehicle.toUpperCase().charAt(0) + this.typeVehicle.substring(1), this.model, this.color, this.horsePower);
    }
}
