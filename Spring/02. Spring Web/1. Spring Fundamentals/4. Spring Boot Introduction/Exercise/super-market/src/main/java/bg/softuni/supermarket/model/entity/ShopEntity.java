package bg.softuni.supermarket.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shops")
public class ShopEntity extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String address;

    @Column
    private String name;

    @ManyToOne
    private TownEntity town;

    @OneToMany(mappedBy = "shop")
    private Set<SellerEntity> sellers;

    @ManyToMany
    private Set<ProductEntity> products;

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

    public TownEntity getTown() {
        return town;
    }

    public ShopEntity setTown(TownEntity town) {
        this.town = town;
        return this;
    }

    public Set<SellerEntity> getSellers() {
        return sellers;
    }

    public ShopEntity setSellers(Set<SellerEntity> sellers) {
        this.sellers = sellers;
        return this;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public ShopEntity setProducts(Set<ProductEntity> products) {
        this.products = products;
        return this;
    }
}
