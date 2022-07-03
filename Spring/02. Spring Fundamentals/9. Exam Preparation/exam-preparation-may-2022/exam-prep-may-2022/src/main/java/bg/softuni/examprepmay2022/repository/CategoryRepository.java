package bg.softuni.examprepmay2022.repository;

import bg.softuni.examprepmay2022.model.entity.CategoryEntity;
import bg.softuni.examprepmay2022.model.entity.enums.ShipTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    CategoryEntity findByName(ShipTypeEnum name);
}
