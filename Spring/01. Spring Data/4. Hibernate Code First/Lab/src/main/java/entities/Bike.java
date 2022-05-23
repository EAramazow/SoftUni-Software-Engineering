package entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "bikes")
public class Bike extends Vehicle{

    public Bike () {

    }

    public Bike(String type, String model, BigDecimal price, String fuelType) {
        super(type, model, price, fuelType);
    }

    public Bike(long id, String type, String model, BigDecimal price, String fuelType) {
        super(id, type, model, price, fuelType);
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
