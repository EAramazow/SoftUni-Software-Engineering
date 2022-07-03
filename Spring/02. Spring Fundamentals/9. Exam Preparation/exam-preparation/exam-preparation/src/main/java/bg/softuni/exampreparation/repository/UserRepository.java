package bg.softuni.exampreparation.repository;

import bg.softuni.exampreparation.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    @Query("SELECT u FROM UserEntity u ORDER BY size(u.orders) DESC")
    List<UserEntity> findAllByOrdersCountDescending();

}
