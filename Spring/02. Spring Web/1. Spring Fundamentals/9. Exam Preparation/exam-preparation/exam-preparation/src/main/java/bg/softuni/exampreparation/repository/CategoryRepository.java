package bg.softuni.exampreparation.repository;

import bg.softuni.exampreparation.model.entity.CategoryEntity;
import bg.softuni.exampreparation.model.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findByName(CategoryNameEnum name);

}
