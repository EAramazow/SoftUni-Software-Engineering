package L07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException;
}