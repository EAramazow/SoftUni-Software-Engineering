package bg.softuni.exampreparation.service.impl;

import bg.softuni.exampreparation.model.entity.CategoryEntity;
import bg.softuni.exampreparation.model.enums.CategoryNameEnum;
import bg.softuni.exampreparation.repository.CategoryRepository;
import bg.softuni.exampreparation.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum
                .values())
                .forEach(categoryNameEnum -> {
                    CategoryEntity category = new CategoryEntity();
                    category.setName(categoryNameEnum);
                    switch (categoryNameEnum) {
                        case CAKE -> category.setNeededTime(10);
                        case DRINK -> category.setNeededTime(1);
                        case COFFEE -> category.setNeededTime(2);
                        case OTHER -> category.setNeededTime(5);
                    }

                    categoryRepository.save(category);
                });

    }
}
