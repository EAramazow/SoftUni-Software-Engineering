package bg.softuni.supermarket.repository;

import bg.softuni.supermarket.model.entity.TownEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<TownEntity, String> {
}
