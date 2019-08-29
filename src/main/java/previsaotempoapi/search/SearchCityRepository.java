package previsaotempoapi.search;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchCityRepository extends JpaRepository<SearchCity, Integer> { }
