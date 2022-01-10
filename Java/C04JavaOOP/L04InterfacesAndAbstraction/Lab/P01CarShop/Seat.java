package L04InterfacesAndAbstraction.Lab.P01CarShop;

public class Seat implements Car {
    private final String model;
    private final String color;
    private final Integer horsePower;
    private final String countryProduce;

    public Seat(String model, String color, Integer horsePower, String countryProduce) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduce = countryProduce;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.countryProduce;
    }


    @Override
    public String toString() {
        return "This is " + model + " produced in " + countryProduce + " and have " + Car.TIRES + " tires";
    }
}
