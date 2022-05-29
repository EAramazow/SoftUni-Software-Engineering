package bg.softuni.supermarket.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity{

    @Column(name = "best_before")
    private LocalDate bestBefore;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    private CategoryEntity category;

    @ManyToMany(mappedBy = "products")
    private Set<ShopEntity> shops;

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public ProductEntity setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductEntity setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public ProductEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public Set<ShopEntity> getShops() {
        return shops;
    }

    public ProductEntity setShops(Set<ShopEntity> shops) {
        this.shops = shops;
        return this;
    }
}
