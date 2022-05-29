package bg.softuni.supermarket.repository;

import bg.softuni.supermarket.model.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, String> {
}
