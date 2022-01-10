package L04InterfacesAndAbstraction.Lab.P02CarShopExtend;


public class Seat extends CarImplementation implements Sellable{

    private final Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduce, Double price) {
        super(model, color, horsePower, countryProduce);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + getModel() + " sells for " + price;
    }
}
