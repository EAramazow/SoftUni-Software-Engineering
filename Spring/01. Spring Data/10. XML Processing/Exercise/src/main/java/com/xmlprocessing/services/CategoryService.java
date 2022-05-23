package com.xmlprocessing.services;

import com.xmlprocessing.models.dtos.CategorySeedDto;
import com.xmlprocessing.models.entities.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories(List<CategorySeedDto> categories);

    long getEntityCount();

    Set<Category> getRandomCategories();
}
