package L07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory;

import L07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.interfaces.Repository;
import L07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.interfaces.Runnable;
import L07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.interfaces.UnitFactory;
import L07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.core.Engine;
import L07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.core.factories.UnitFactoryImpl;
import L07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
