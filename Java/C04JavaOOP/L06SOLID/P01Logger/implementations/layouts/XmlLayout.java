package L06SOLID.Exercise.P01Logger.implementations.layouts;

import L06SOLID.Exercise.P01Logger.enumerations.ReportLevel;
import L06SOLID.Exercise.P01Logger.interfaces.Layout;

public class XmlLayout implements Layout {

    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        return String.format
                ("<log>\n" +
                "   <date>%s</date>\n" +
                "   <level>%s</level>\n" +
                "   <message>%s</message>\n" +
                "</log>\n", time, reportLevel, message);
    }
}
