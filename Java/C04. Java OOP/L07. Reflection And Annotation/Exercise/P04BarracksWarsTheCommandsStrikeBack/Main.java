package L07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack;

import L07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.interfaces.Repository;
import L07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.interfaces.Runnable;
import L07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.interfaces.UnitFactory;
import L07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.core.Engine;
import L07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.core.factories.UnitFactoryImpl;
import L07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();

    }
}
