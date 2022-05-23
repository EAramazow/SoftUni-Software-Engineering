package entities;

import org.hibernate.annotations.Tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name ="trucks")
public class Truck extends Vehicle{

//    @Column("load_capacity")
    private double loadCapacity;

    public Truck (){

    }

    public Truck(String type, String model, BigDecimal price, String fuelType, int loadCapacity) {
        super(type, model, price, fuelType);
        this.loadCapacity = loadCapacity;
    }

    public Truck(long id, String type, String model, BigDecimal price, String fuelType, int loadCapacity) {
        super(id, type, model, price, fuelType);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "loadCapacity=" + loadCapacity +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
