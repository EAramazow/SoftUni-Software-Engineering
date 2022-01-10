package L06SOLID.Exercise.P01Logger.implementations.layouts;

import L06SOLID.Exercise.P01Logger.enumerations.ReportLevel;
import L06SOLID.Exercise.P01Logger.interfaces.Layout;

public class SimpleLayout implements Layout {


    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        return String.format("%s - %s - %s", time, reportLevel, message);
    }
}
