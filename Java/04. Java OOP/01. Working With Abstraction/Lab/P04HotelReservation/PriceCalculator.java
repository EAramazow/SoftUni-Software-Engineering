package L01WorkingWithAbstraction.Lab.P04HotelReservation;

public class PriceCalculator {

    private double pricePerDay;
    private int days;
    private Season season;
    private Discount discount;

    public PriceCalculator(double pricePerDay, int days, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }

    public double calculatedPrice() {
        return (pricePerDay * season.getMultiplier()) * days * (1 - discount.getPercentage());
    }
}
