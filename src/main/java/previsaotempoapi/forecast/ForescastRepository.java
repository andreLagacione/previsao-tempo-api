package previsaotempoapi.forecast;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForescastRepository extends JpaRepository<Forecast, Integer> {
}
