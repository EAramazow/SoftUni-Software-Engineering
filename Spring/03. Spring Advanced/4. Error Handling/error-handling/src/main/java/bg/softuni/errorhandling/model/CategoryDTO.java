package bg.softuni.errorhandling.model;

public class CategoryDTO {

    private final String categoryName;

    public CategoryDTO(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
