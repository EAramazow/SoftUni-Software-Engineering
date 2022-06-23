package bg.softuni.examprepmay2022.seeder;

import bg.softuni.examprepmay2022.model.entity.CategoryEntity;
import bg.softuni.examprepmay2022.model.entity.enums.ShipTypeEnum;
import bg.softuni.examprepmay2022.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategorySeeder implements CommandLineRunner {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            List<CategoryEntity> categoryList = Arrays.stream(ShipTypeEnum.values())
                    .map(CategoryEntity::new)
                    .collect(Collectors.toList());

            this.categoryRepository.saveAll(categoryList);
        }
    }
}
