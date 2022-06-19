package bg.softuni.exampreparation.service;

import bg.softuni.exampreparation.model.entity.CategoryEntity;
import bg.softuni.exampreparation.model.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
