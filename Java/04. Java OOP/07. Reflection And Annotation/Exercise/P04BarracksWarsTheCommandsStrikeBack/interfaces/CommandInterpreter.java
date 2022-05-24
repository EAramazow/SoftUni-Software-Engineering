package L07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
