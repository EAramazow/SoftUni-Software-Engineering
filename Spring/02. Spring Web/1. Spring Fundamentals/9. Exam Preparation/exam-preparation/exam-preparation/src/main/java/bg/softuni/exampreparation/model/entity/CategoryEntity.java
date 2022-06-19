package bg.softuni.exampreparation.model.entity;

import bg.softuni.exampreparation.model.enums.CategoryNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CategoryNameEnum category;
    @Column(nullable = false)
    private Integer neededTime;

    public CategoryEntity() {
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public CategoryEntity setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    public Integer getNeededTime() {
        return neededTime;
    }

    public CategoryEntity setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
