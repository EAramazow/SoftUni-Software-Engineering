package L07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.core.commands;

import L07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.interfaces.Repository;
import L07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.interfaces.UnitFactory;

public class Fight extends Command {

    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}