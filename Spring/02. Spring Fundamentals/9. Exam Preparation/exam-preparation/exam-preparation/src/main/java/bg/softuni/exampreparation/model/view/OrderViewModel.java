package bg.softuni.exampreparation.model.view;

import bg.softuni.exampreparation.model.entity.CategoryEntity;
import java.math.BigDecimal;

public class OrderViewModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private CategoryEntity category;

    public OrderViewModel() {
    }

    public Long getId() {
        return id;
    }

    public OrderViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public OrderViewModel setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }
}
