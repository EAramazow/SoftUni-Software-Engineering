package exam.repository;


import exam.model.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
    boolean existsByName(String name);

    Town findByName(String name);
}
