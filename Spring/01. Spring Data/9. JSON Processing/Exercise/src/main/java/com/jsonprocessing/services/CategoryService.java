package com.jsonprocessing.services;

import com.jsonprocessing.models.entities.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> findRandomCategories();
}
