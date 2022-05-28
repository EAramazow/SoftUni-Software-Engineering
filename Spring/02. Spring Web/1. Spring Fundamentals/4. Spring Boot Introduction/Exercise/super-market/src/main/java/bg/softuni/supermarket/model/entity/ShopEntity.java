package bg.softuni.supermarket.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shops")
public class ShopEntity extends BaseEntity{

    @Column(name = "address", unique = true, nullable = false)
    private String address;
    @Column(name = "name")
    private String name;


    public String getAddress() {
        return address;
    }

    public ShopEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShopEntity setName(String name) {
        this.name = name;
        return this;
    }

}
