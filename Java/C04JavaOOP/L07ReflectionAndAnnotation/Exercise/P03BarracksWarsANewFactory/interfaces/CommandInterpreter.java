package L07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
