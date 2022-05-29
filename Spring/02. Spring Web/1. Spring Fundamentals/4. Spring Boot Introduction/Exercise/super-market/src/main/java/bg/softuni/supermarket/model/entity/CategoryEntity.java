package bg.softuni.supermarket.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<ProductEntity> products;

    public String getName() {
        return name;
    }

    public CategoryEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public CategoryEntity setProducts(Set<ProductEntity> products) {
        this.products = products;
        return this;
    }
}
