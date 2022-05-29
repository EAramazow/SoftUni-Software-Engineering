package bg.softuni.supermarket.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "towns")
public class TownEntity extends BaseEntity{

    @Column(unique = true,nullable = false)
    private String name;

    @OneToMany(mappedBy = "town")
    private Set<ShopEntity> shops;

    public String getName() {
        return name;
    }

    public TownEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Set<ShopEntity> getShops() {
        return shops;
    }

    public TownEntity setShops(Set<ShopEntity> shops) {
        this.shops = shops;
        return this;
    }
}
