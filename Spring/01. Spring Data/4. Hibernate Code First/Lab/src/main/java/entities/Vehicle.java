package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table (name="vehicles")
@Inheritance (strategy =  InheritanceType.JOINED)

public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String type;
    String model;
    BigDecimal price;

    @Column(name="fuel_type")
    String fuelType;
    @ManyToMany(mappedBy = "vehicles")
    private Set<Driver> drivers = new HashSet<>();
    public Vehicle (){

    }

    public Vehicle(String type, String model, BigDecimal price, String fuelType) {
        this.type = type;
        this.model = model;
        this.price = price;
        this.fuelType = fuelType;
    }

    public Vehicle(Long id, String type, String model, BigDecimal price, String fuelType) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.price = price;
        this.fuelType = fuelType;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id;
    }



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
