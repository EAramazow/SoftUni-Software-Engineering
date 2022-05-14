package softuni.exam.models.dto;

import softuni.exam.models.enums.DaysOfWeek;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "forecast")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastSeedDto {

//    @XmlElement(name = "day_of_week")
//    private DaysOfWeek dayOfWeek;

    @XmlElement(name = "days_of_week")
    private DaysOfWeek daysOfWeek;
    @XmlElement(name = "max_temperature")
    private Double maxTemperature;
    @XmlElement(name = "min_temperature")
    private Double minTemperature;
    @XmlElement(name = "sunrise")
    private String sunrise;
    @XmlElement(name = "sunset")
    private String sunset;
    @XmlElement(name = "city")
    private Long city;

//    @Pattern(regexp = "^(FRIDAY|SATURDAY|SUNDAY)+$")
//    public DaysOfWeek getDayOfWeek() {
//        return dayOfWeek;
//    }
//
//    public void setDayOfWeek(DaysOfWeek dayOfWeek) {
//        this.dayOfWeek = dayOfWeek;
//    }

    public DaysOfWeek getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(DaysOfWeek daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    @Min(-20)
    @Max(60)
    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @Min(-50)
    @Max(40)
    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }
}
