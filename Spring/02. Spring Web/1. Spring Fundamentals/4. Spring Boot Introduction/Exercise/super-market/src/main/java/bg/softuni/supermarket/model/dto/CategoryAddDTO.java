package bg.softuni.supermarket.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class CategoryAddDTO {

    @Size(min = 2, message = "Category name must be at least two characters")
    private String name;

    public String getName() {
        return name;
    }

    public CategoryAddDTO setName(String name) {
        this.name = name;
        return this;
    }
}
