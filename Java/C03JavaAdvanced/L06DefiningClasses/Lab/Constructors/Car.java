package DefiningClasses.Lab.Constructors;

import org.w3c.dom.ls.LSOutput;

public class Car {
    String brand;
    String model;
    int horsePower;

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    // constructor chaining

    public Car(String brand, String model) {
        this(brand, model, -1);
    }

    public Car(String brand, int horsePower) {
        this(brand, "unknown", horsePower);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public Car(String brand) {
        this(brand, "unknown", -1);
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }
}
