package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    private static final int SHORTHAIRCAT_KILOGRAMS = 7;
    private static final int INCREASED_KILOGRAMS = 1;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(SHORTHAIRCAT_KILOGRAMS);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + INCREASED_KILOGRAMS);
    }
}
