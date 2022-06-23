package bg.softuni.examprepmay2022.model.entity;

import bg.softuni.examprepmay2022.model.entity.enums.ShipTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, unique = true)
    private ShipTypeEnum name;

    public CategoryEntity() {
    }

    public CategoryEntity(ShipTypeEnum name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public CategoryEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public ShipTypeEnum getName() {
        return name;
    }

    public CategoryEntity setName(ShipTypeEnum name) {
        this.name = name;
        return this;
    }
}
