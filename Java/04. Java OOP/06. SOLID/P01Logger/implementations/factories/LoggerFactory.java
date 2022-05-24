package L06SOLID.Exercise.P01Logger.implementations.factories;

import L06SOLID.Exercise.P01Logger.implementations.MessageLogger;
import L06SOLID.Exercise.P01Logger.interfaces.Appender;
import L06SOLID.Exercise.P01Logger.interfaces.Factory;
import L06SOLID.Exercise.P01Logger.interfaces.Logger;

public class LoggerFactory implements Factory<Logger> {
    AppenderFactory appenderFactory;

    public LoggerFactory() {
        this.appenderFactory = new AppenderFactory();
    }




    @Override
    public Logger produce(String input) {
        String[] tokens = input.split(System.lineSeparator());
        Appender[] appenders = new Appender[tokens.length];

        for (int i = 0; i < appenders.length; i++) {
            appenders[i] = this.appenderFactory.produce(tokens[i]);
        }

        return new MessageLogger(appenders);
    }
}
