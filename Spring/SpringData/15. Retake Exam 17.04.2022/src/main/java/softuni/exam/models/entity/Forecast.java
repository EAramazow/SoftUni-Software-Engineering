package softuni.exam.models.entity;

import softuni.exam.models.enums.DaysOfWeek;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "forecasts")
public class Forecast extends BaseEntity{

    private DaysOfWeek daysOfWeek;
    private Double maxTemperature;
    private Double minTemperature;
    private Time sunrise;
    private Time sunset;

    private City city;

    public Forecast() {
    }

    @Column(name = "days_of_week", nullable = false)
    @Enumerated(EnumType.STRING)
    public DaysOfWeek getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(DaysOfWeek daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    @Column(name = "max_temperature", nullable = false)
    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @Column(name = "min_temperature", nullable = false)
    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    @Column(name = "sunrise", nullable = false)
    public Time getSunrise() {
        return sunrise;
    }

    public void setSunrise(Time sunrise) {
        this.sunrise = sunrise;
    }

    @Column(name = "sunset", nullable = false)
    public Time getSunset() {
        return sunset;
    }

    public void setSunset(Time sunset) {
        this.sunset = sunset;
    }

    @ManyToOne
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
