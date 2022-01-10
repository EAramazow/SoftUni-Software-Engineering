package L07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.units;

public class Horseman extends AbstractUnit{
    private final static int HORSEMAN_HEALTH = 50;
    private final static int HORSEMAN_DAMAGE = 10;

    public Horseman(){
        super(HORSEMAN_HEALTH, HORSEMAN_DAMAGE);
    }
}
