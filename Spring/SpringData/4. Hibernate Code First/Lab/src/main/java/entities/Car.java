package entities;


import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cars")
public class Car extends Vehicle{

    private int seats;

    @OneToOne(mappedBy = "car")
    private PlateNumber plate;

    public Car () {

    }

    public Car(String type, String model, BigDecimal price, String fuelType, int seats) {
        super(type, model, price, fuelType);
        this.seats = seats;
    }

    public Car(long id, String type, String model, BigDecimal price, String fuelType, int seats) {
        super(id, type, model, price, fuelType);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public PlateNumber getPlate() {
        return plate;
    }

    public void setPlate(PlateNumber plate) {
        this.plate = plate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seats=" + seats +
                ", plate=" + plate +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
