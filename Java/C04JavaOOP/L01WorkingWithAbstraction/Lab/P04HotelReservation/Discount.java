package L01WorkingWithAbstraction.Lab.P04HotelReservation;

public enum Discount {

    VIP(0.20),
    SecondVisit(0.10),
    None(0);

    private double percentage;

    Discount(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public static Discount parseDiscount(String discount) {

        switch (discount) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SecondVisit;
            case "None":
                return None;
            default:
                throw new IllegalArgumentException("Unknown discount type " + discount);
        }
    }
}
