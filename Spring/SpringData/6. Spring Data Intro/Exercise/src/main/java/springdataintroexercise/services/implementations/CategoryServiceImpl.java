package springdataintroexercise.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataintroexercise.constants.GlobalConstants;
import springdataintroexercise.entities.Category;
import springdataintroexercise.repositories.CategoryRepository;
import springdataintroexercise.services.CategoryService;
import springdataintroexercise.utils.FileUtil;

import java.io.IOException;
import java.util.Arrays;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCategories() throws IOException {

        if (this.categoryRepository.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtil.readFileContent(GlobalConstants.CATEGORIES_FILE_PATH);


        Arrays.stream(fileContent).forEach(row -> {
            Category category = new Category(row);

            this.categoryRepository.saveAndFlush(category);
        });

    }

    @Override
    public Category getCategoryById(Long id) {
        return this.categoryRepository.getById(id);
    }
}
