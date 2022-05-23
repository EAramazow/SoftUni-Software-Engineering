package springdataintroexercise.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdataintroexercise.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
