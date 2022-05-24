package L06SOLID.Exercise.P01Logger.interfaces;

import L06SOLID.Exercise.P01Logger.enumerations.ReportLevel;

public interface Appender {
    void append(String time, String message, ReportLevel reportLevel);
    void setReportLevel(ReportLevel reportLevel);
}
