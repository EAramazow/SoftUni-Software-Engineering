package entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "planes")
public class Plane extends Vehicle{
    @Column(name="passenger_capacity")
    private int passengerCapacity;
    @ManyToOne
    private Company company;

    public Plane(){}


    public Plane(int passengerCapacity, Company company) {
        this.passengerCapacity = passengerCapacity;
        this.company = company;
    }

    public Plane(String type, String model, BigDecimal price, String fuelType, int passengerCapacity, Company company) {
        super(type, model, price, fuelType);
        this.passengerCapacity = passengerCapacity;
        this.company = company;
    }

    public Plane(Long id, String type, String model, BigDecimal price, String fuelType, int passengerCapacity, Company company) {
        super(id, type, model, price, fuelType);
        this.passengerCapacity = passengerCapacity;
        this.company = company;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int seats) {
        this.passengerCapacity = seats;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Plane{");
        sb.append(super.toString());
        sb.append("passengerCapacity=").append(passengerCapacity);
        sb.append('}');
        return sb.toString();
    }
}
