package catHouse.entities.cat;

public class LonghairCat extends BaseCat{
    private static final int INCREASED_KILOGRAMS = 3;
    private static final int LONGHAIRCAT_KILOGRAMS = 9;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(LONGHAIRCAT_KILOGRAMS);
    }

    @Override
    public void eating(){
        super.setKilograms(super.getKilograms() + INCREASED_KILOGRAMS);
    }
}
