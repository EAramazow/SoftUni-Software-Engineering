package L07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.core.commands;

import L07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.interfaces.Repository;
import L07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.interfaces.Unit;
import L07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.interfaces.UnitFactory;



    public class Add extends Command {

        public Add(String[] data, Repository repository, UnitFactory unitFactory) {
            super(data, repository, unitFactory);
        }

        @Override
        public String execute() {
            String unitType = getData()[1];
            Unit unitToAdd = getUnitFactory().createUnit(unitType);
            getRepository().addUnit(unitToAdd);
            String output = unitType + " added!";
            return output;
        }
    }