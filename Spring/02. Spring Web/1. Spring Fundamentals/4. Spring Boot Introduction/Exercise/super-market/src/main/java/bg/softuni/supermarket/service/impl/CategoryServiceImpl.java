package bg.softuni.supermarket.service.impl;

import bg.softuni.supermarket.model.dto.CategoryAddDTO;
import bg.softuni.supermarket.repository.CategoryRepository;
import bg.softuni.supermarket.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Override
    public String addCategory(String categoryName) {

        CategoryAddDTO categoryAddDto = new CategoryAddDTO();
        categoryAddDto.setName(categoryName);

        return "Successfully added category!";
    }
}
