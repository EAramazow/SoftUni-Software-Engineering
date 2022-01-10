package L06SOLID.Exercise.P01Logger.implementations.factories;

import L06SOLID.Exercise.P01Logger.enumerations.ReportLevel;
import L06SOLID.Exercise.P01Logger.implementations.appenders.ConsoleAppender;
import L06SOLID.Exercise.P01Logger.implementations.appenders.FileAppender;
import L06SOLID.Exercise.P01Logger.interfaces.Appender;
import L06SOLID.Exercise.P01Logger.interfaces.Factory;
import L06SOLID.Exercise.P01Logger.interfaces.Layout;

public class AppenderFactory implements Factory<Appender> {

    private LayoutFactory layoutFactory;

    public AppenderFactory() {
        this.layoutFactory = new LayoutFactory();
    }


    @Override
    public Appender produce(String input) {
        String[] tokens = input.split("\\s+");

        String appenderType = tokens[0];
        String layoutType = tokens[1];

        Layout layout = layoutFactory.produce(layoutType);
        Appender appender = null;

        if (appenderType.equals("ConsoleAppender")) {
            appender = new ConsoleAppender(layout);

        } else if (appender.equals("FileAppender")) {
            appender = new FileAppender(layout);
        }

        if (tokens.length >= 3) {
        appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
        }

        return appender;
    }
}
