package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.enums.DaysOfWeek;

import java.util.Optional;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    boolean existsByDaysOfWeek(DaysOfWeek daysOfWeek);

    boolean existsByCityId(Long id);

}
