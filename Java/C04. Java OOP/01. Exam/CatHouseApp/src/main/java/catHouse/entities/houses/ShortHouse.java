package catHouse.entities.houses;

import catHouse.entities.cat.BaseCat;

public class ShortHouse extends BaseHouse {
    private static final int SHORTHOUSE_CAPACITY = 15;

    public ShortHouse(String name) {
        super(name, SHORTHOUSE_CAPACITY);
    }
}
