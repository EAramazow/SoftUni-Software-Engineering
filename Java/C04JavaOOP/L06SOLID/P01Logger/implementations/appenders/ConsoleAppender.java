package L06SOLID.Exercise.P01Logger.implementations.appenders;

import L06SOLID.Exercise.P01Logger.enumerations.ReportLevel;
import L06SOLID.Exercise.P01Logger.interfaces.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if (this.canAppend(reportLevel)) {
            String formattedMessage = this.layout.format(time, message, reportLevel);
            increaseMessageCount();
            System.out.println(formattedMessage);
        }
    }
}
